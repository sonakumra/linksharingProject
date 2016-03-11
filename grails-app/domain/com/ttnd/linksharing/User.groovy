package com.ttnd.linksharing

import com.ttnd.linksharing.vo.UserVO

class User {
    String email;
    String username;
    String password;
    String firstName;
    String lastName;
    byte[] photo;
    Boolean admin;
    Boolean active;
    String confirmPassword;
    String subscribedTopic
    Date lastUpdated;
    Date dateCreated;

    static transients = ['name', 'confirmPassword', 'subscribedTopic']
    //static transients = ['confirmPassword']


    static constraints = {
        email unique: true, email: true, blank: false
        password blank: false, minSize: 5
        firstName blank: false, nullable: false
        lastName blank: false
        admin nullable: true
        active nullable: true
        photo nullable: true
        username blank: false
        confirmPassword(nullable: true, blank: true, bindable: true, validator: { confirmPassword, obj ->
            Integer id = 0
            id = obj.getId()
            if (!obj.id && obj.password != confirmPassword) {
                "password.mismatch.confirmPassword"
            }
        })
        subscribedTopic bindable: true


    }
    static hasMany = [topics      : Topic, subscribtion: Subscription,
                      readingItems: ReadingItem, resources: Resource]

    String getName() {
        [this.firstName, this.lastName].join(' ')

    }

    String toString() {
        return username
    }

    Map toMap() {
        [email:email,
        password:password,
        firstName:firstName]
    }

    static mapping = {
        photo sqlType: 'longblob'
        id sort: 'desc'
    }

    String getSubscribedTopic() {
        return subscribedTopic;
    }

    Boolean canDeleteResource(Long id) {

        Resource resource = Resource.read(id)
        if (this.admin || resource.createdBy.id == this.id) {
            return true
        } else {
            return false
        }

    }

    public Integer getScore(Resource resource) {
        ResourceRating resourceRating = ResourceRating.findByUserAndResources(this, resource)
        return resourceRating.score
    }

    Boolean isSubscribed(Long topicId) {
        Topic topic = Topic.load(topicId)
        if (Subscription.findByUserAndTopic(this, topic)) {
            return true
        } else {
            return false
        }
    }

    static List<Topic> getSubscribedTopics(Long id) {
        List<Topic> topicList = Subscription.createCriteria().list() {
            projections {
                property('topic')
            }
            eq('user.id', id)
        }
        return topicList
    }

//    UserVO getUserDetails() {
//        return new UserVO(userId: id,fname: firstName,userName:username , lname: lastName, email: email, image: photo, isAdmin: admin, isActive: active)
//    }


}
