package com.ttnd.linksharing

import com.ttnd.linksharing.co.ResourceSearchCO
import com.ttnd.linksharing.vo.RatingInfoVO
import com.ttnd.linksharing.vo.ResourceVo
import com.ttnd.linksharing.vo.TopicVO

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

    public static List<Resource> getTopPosts() {

        List<Resource> resources = []

        def result = ResourceRating.createCriteria().list(max: 5) {
            projections{
                property('resources.id')
            }

            groupProperty('resources.id')
            count('id', 'totalVotes')
            order('totalVotes', 'desc')
        }

        List list = result.collect {it[0]}
        resources = Resource.getAll(list)

        return resources
    }
    static Boolean checkResourceType(Long id) {
        Resource resource = Resource.get(id)
        if (resource.class.equals(LinkResource)) {
            return false
        } else {
            return true
        }
    }





}
