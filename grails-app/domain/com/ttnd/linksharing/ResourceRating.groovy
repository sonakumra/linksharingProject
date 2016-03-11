package com.ttnd.linksharing

class ResourceRating {
    Resource resources
    User user
    Integer score
    static constraints = {
        score max: 5, min:1
        user unique: 'resources'
    }
    static belongsTo = [resources: Resource]

}
