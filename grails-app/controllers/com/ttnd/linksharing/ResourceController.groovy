package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO
import com.ttnd.linksharing.vo.RatingInfoVO

class ResourceController {

    def index() {}

    def resourceDeletion(Long id) {//????


        try {
            Resource resource = Resource.load(id)
            resource.delete(flush: true)
            render "Resource Deleted"
        }
        catch (Exception e) {
            render e.message
        }

    }
    def search(ResourceSearchCO co) {
       if (co.q)
           co.visiblity=Visiblity.PUBLIC
        //println("co:${co.properties}")
      //  List<Resource> resources = Resource.search(co).list()
      //  render "resources $resources"


    }
    def show(Long id){

        Resource resource = Resource.get(id)
        RatingInfoVO ratingInfoVO = resource.getRatingtInfo()
        render(contentType: 'application/json') {
            ratingInfoVO
        }
    }
    def saveLinkResource(String url, String description, String topicName){
        User user=session.user
        Topic topic=Topic.findByNameAndCreatedBy(topicName,user)
        Resource linkResource=new LinkResource(url: url,description: description,createdBy: user,topic: topic)
        if(linkResource.validate()){
            linkResource.save(flush: true)
            flash.message="Link Resource Saved"
            render flash.message
        }
        else{
            def err
            if(linkResource.hasErrors()) {
                err = linkResource.errors
            }
            render text: "Link Resource not Saved"+err
           // render "problrmmmmmmmmmm"
            redirect(controller: 'user',action: 'index')

        }
    }
}
