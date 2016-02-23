package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO

abstract class Resource {
    String description;
    User createdBy;
    Topic topic
    Date lastUpdated;
    Date dateCreated;
    static mapping = {
        description(type: 'text')
    }

    static constraints = {
    }
    static hasMany = [rating: ResourceRating, readingItems: ReadingItem]

    String toString() {
        return "${topic} has resource -> ${description}"
    }
    static belongsTo = [topic: Topic]

    void namedQuery(ResourceSearchCO co) {


    }
}
