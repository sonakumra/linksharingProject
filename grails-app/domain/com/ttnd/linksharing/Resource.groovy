package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO
import com.ttnd.linksharing.vo.RatingInfoVO

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
    static transients= [ 'ratingInfo' ]

    static hasMany = [ratings: ResourceRating, readingItems: ReadingItem]

    String toString() {
        return "${topic} has resource -> ${description}"
    }
    static belongsTo = [topic: Topic]

    static namedQueries = {
        search { ResourceSearchCO co ->
            if (co.topicId) {
                'topic' {
                    eq('id', co.topicId)
                    eq('visiblity', co.visiblity)
                }
                Resource.findAllById(co.topicId)
            }
        }
    }
    RatingInfoVO getRatingtInfo() {
        Object[] result = ResourceRating.createCriteria().get {
            projections {
                count('id', 'totalVotes')
                avg('score')
                sum('score')
            }

            eq('resources', this)
            order('totalVotes', 'desc')
        }

        new RatingInfoVO(totalVotes: result[0], averageScore: result[1], totalScore: result[2])
    }

}
