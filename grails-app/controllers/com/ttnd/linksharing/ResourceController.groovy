package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO
import com.ttnd.linksharing.vo.RatingInfoVO

class ResourceController {

    def index() {}

    def resourceDeletion(Long id) {//?????runn


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
}
