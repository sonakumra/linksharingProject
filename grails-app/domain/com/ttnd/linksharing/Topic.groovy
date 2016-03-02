package com.ttnd.linksharing

import com.ttnd.linksharing.vo.TopicVO

class Topic {
    String name;
    Date dateCreated;
    Date lastUpdated;
    Visibility visibility
    User createdBy
    String subscribedUser



    static constraints = {
        name blank: false, unique: 'createdBy'
        visibility(inlist: Visibility.values() as List);
        subscribedUser bindable:true
    }
    static transients=['subscribedUser']


    static hasMany = [subsciptions: Subscription, resources: Resource]

    def afterInsert() {
        Topic.withNewSession {
            Subscription subscription = new Subscription(user: createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS)
            subscription.save()
        }

    }
    String getSubscribedUser(){
        return subscribedUser
    }


    String toString() {
        return name

    }
    static mapping = {
        sort name: 'asc'
    }


    static List<TopicVO> getTrendingTopics() {
        List<TopicVO> trendingTopics = []
        Resource.createCriteria().list {
            projections {
                createAlias('topic', 't')
                groupProperty('t.id')
                property('t.name')
                property('t.visibility')
                count('t.id', 'topicCount')
                property('t.createdBy')
            }

            order('topicCount', 'desc')
            order('t.name', 'asc')
            maxResults(5)
        }?.each {
            trendingTopics.add(new TopicVO(id: it[0], name: it[1], visibility: it[2], count: it[3], createdBy: it[4]))
        }

        return trendingTopics
    }

    static List getTopicsOfAUser(User user) {
        List<Topic> topicList = Topic.findAllByCreatedBy(user)
        List topicNames = topicList.collect { it.name }
        return topicNames
    }
   /* static List getUsersOfTopic(Topic topic) {
        List<User> userList = User.findAllByCreatedBy(topic)
        List userNames = userList.collect { it.name }
        return UserNames
    }*/


}







