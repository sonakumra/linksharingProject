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
    static transients=['subscribedUsers']


    static hasMany = [subsciptions: Subscription, resources: Resource]

    def afterInsert() {
        Topic.withNewSession {
            Subscription subscription = new Subscription(user: createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS)
            subscription.save()
        }

    }
//    String getSubscribedUser(){
//        return subscribedUser
//    }


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

     List<User> getSubscribedUsers() {
        List<User> SubscribedList = Subscription.createCriteria().list {
            projections {
                property('user')
            }
            eq('topic.id', id)
        }
        return SubscribedList
    }

    public Boolean isTopicPublic() {
        if (visibility == Visibility.PUBLIC)
            return true
        return false
    }
    public Boolean canViewedBy(User user) {

        if (this.isTopicPublic() || user.isAdmin || Subscription.findByUserAndTopic(user, this)) {
            return true
        }

        return false

    }
    List<Resource> getPost()
    {
        List<Resource> post = Resource.findAllByTopic(this)
        return post
    }


}







