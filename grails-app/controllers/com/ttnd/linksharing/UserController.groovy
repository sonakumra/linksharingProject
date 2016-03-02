package com.ttnd.linksharing

import com.ttnd.linksharing.vo.TopicVO


class UserController {

    def index() {
       // render "hello"
        //def user = User.get(id)
        User user = session.user
       // render "User DashBoard ${session} ${user} ${user.username}"
       // List topicsOfUserList=Topic.getTopicsOfAUser(user)
       // render (view:'index',model:[topicsOfUser:topicsOfUserList])
        List subscriptionList = Subscription.getSubscribedTopic(user)
        List<TopicVO>topicVOList=Topic.getTrendingTopics()
        List<ReadingItem> readingItems = ReadingItem.findAllByUser(user)
        render(view:'index',model:[subscriptionTopic:subscriptionList,topicVOList:topicVOList,readingItems:readingItems ] )

      //  UserVO userDetail=session.user.getUserDetails()
     //   render (view:'index', model:[subscribedTopics:session.user.subscribedTopics,topicVOList:topicVOList,
                                   //  userDetails:userDetail])

    }

    def register() {

        User user = new User(email: params.email, username: params.username, firstName: params.firstName, lastName: params.lastName, password: params.password, confirmPassword: params.confirmPassword)
        //  User user=new User(username: "user",firstName: "user1",lastName: "lname",email: "a@b.com",password: Constants.PASSWORD,confirmPassword: Constants.PASSWORD,active: true)
        if (user.validate() && user.save(flush: true, failOnError: true)) {
            flash.message = "Successful registration"
            render flash.message
        } else {
            flash.error = " user could not be registered"
            render "~FAILURE~"
        }


    }
}
