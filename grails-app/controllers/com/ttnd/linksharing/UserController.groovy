package com.ttnd.linksharing

import com.ttnd.linksharing.co.UserCO
import com.ttnd.linksharing.vo.PostVo
import com.ttnd.linksharing.vo.TopicVO
import com.ttnd.linksharing.vo.UserVO
import org.springframework.web.multipart.MultipartRequest


class UserController {

    def assetResourceLocator

    def index() {
        // render "hello"
        //def user = User.get(id)
        User user = session.user
        // render "User DashBoard ${session} ${user} ${uster.username}"
        // List topicsOfUserList=Topic.getTopicsOfAUser(user)
        // render (view:'index',model:[topicsOfUser:topicsOfUserList])
        List<Topic> subscriptionList = Subscription.getSubscribedTopic(user)
        List<TopicVO> topicVOList = Topic.getTrendingTopics()
        def readingItems = ReadingItem.getResourceDetails(user)
        List<Topic> topicList = User.getSubscribedTopics(user.id)
        // UserVO userDetail = user.getUserDetails()

        render(view: 'index', model: [subscriptionTopic: subscriptionList, topicVOList: topicVOList, readingItems: readingItems, topicList: topicList])


    }

    def register(UserCO co) {
        if (co.hasErrors()) {
            flash.error = " user could not be registered"
            println "check"
            log.info co.errors.allErrors
            render view: '/login/index', model: [user: co]
        } else {
            User user = co.properties
            if (!params.file.empty) {
                user.photo = params.file.bytes
            }
            if (user.validate()) {
                user.save(flush: true)
                flash.message = "User Registered"
            } else {
                flash.error = "User not Registered"
                render view: '/login/index', model: [user: user]
            }
            redirect(controller: 'login', action: 'index')
        }

        /*else if(user.save(flush: true)) {
            flash.message = "Successful registration"
            redirect(controller: 'login',action: 'loginHandler',params: [username:user.username,password: user.password])
        }*/


    }

    def viewPost(Long id) {
        User user = session.user
        List<PostVo> readingItems = ReadingItem.getResourceDetails(user)
        Resource resource = Resource.read(id)
        println "=====${resource}===="
        println "=====${resource.id}===="
        if (Resource.canViewBy(user, id)) {
            render(view: 'viewPost', model: [readingItemList: readingItems, resource: resource])
        } else {
            render "you cannot view this resource"
        }
    }

    def image(Long id) {
        User user = User.get(id)
        def photo
        if (user.photo) {
            photo = user.photo
        } else {
            photo = assetResourceLocator.findAssetForURI('img.png').getInputStream().getBytes()

        }
        response.outputStream << photo
        response.outputStream.flush()
    }


}
