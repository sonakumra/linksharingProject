package com.ttnd.linksharing

class ResourceRating {
    Resources resources
    User user
    Integer score
    static constraints = {
        score max: 5, min:1
        user unique: 'resources'
    }

}
