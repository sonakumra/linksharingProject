package com.ttnd.linksharing

abstract class Resources {
    String description;
    User createdBy;
    Topic topic
    Date lastUpdated;
    Date dateCreated;
    static mapping = {
        description(type:'text')
    }

    static constraints = {
    }
    static hasMany = [rating:ResourceRating,readingItems:ReadingItem]
    static belongsTo = [topic:Topic]
}
