package com.ttnd.linksharing

class ResourceRating {
    Resources resources
    User user
    Integer score
    static constraints = {
        score max: 5, min:1
        user unique: 'resources'
    }
    public static Resources save(Resources resource) {
        resource.validate()
        if (resource.hasErrors()) {
            resource.errors.each {
                log.error "error while saving resource ${it}--- ${it.allErrors}"
            }
            return null
        } else {
            resource.save(flush: true,failOnError: true)
            return resource
        }
    }
}
