package com.ttnd.linksharing

class ResourceController {

    def index() {}

    def resourceDeletion() {


        try {
            Resource resource = Resource.load(id)
            resource.delete(flush: true)
            render "Resource Deleted"
        }
        catch (Exception e) {
            render e.message
        }

    }
}
