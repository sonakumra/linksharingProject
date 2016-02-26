package com.ttnd.linksharing

import com.ttnd.linksharing.vo.TopicVO

class Topic {
    String name;
    Date dateCreated;
    Date lastUpdated;
    Visibility visibility
    User createdBy


    static constraints = {
        name blank: false, unique: 'createdBy'
        visibility(inlist: Visibility.values() as List);
    }

    static hasMany = [subsciptions: Subscription, resources: Resource]

    def afterInsert() {
        Topic.withNewSession {
            Subscription subscription = new Subscription(user: createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS)
            subscription.save()
        }

    }

    String toString() {
        return name

    }
    static mapping = {
        sort name: 'asc'
    }

    static List<TopicVO> getTrendingTopics() {
        List result = Resource.createCriteria().list {
            projections {
                createAlias("topic", "t")
                groupProperty("t.id")
                property("t.name")
                property("t.visibility")
                count("id", 'totalResources')
                property("t.createdBy")
            }
            eq("t.visibility", Visibility.PUBLIC)
            order("totalResources", "desc")
            order("t.name", "desc")
            maxResults 5
            firstResult 0


        }

        new TopicVO(id: result[0], name: result[1], visibility: result[2], count: result[3], createdBy: result[4])

    }

    static List getTopicsOfAUser(User user) {
        List<Topic> topicList = Topic.findAllByCreatedBy(user)
        List topicNames = topicList.collect { it.name }
        return topicNames
    }

}







