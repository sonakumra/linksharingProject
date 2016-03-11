package com.ttnd.linksharing

import com.ttnd.linksharing.vo.TopicVO

class linksharingTagLib {
//    static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"

    def markRead = { attrs, body ->
        User user = session.user
        String link = "${createLink(controller: 'readingItem', action: 'changeIsRead', params: [id: attrs.id, isRead: !attrs.isRead])}"
        if (user) {
            if (attrs.isRead) {
                out << "<a href=$link>Mark as Unread</a>"
            } else {
                out << "<a href=$link>Mark as Read</a>"
            }


        }
    }
    def showTrendingTopics = {
        List<TopicVO> trendingTopics = Topic.getTrendingTopics()
        out << render(template: '/topic/trendingTopics', model: [trendingTopics: trendingTopics])
    }
    def checkType = { attrs, body ->

        if (Resource.checkResourceType(attrs.id)) {
            out << "<a href=${createLink(controller:'documentResource', action:'download',params:[id:attrs.id])}>Download</a>"
        } else {
            out << "<a href=${attrs.url} target='_blank'>View full site</a>"
        }
    }
    def resourceDelete = { attrs, body ->
        if (session.user) {
            User user = session.user
            if (user.canDeleteResource(attrs.id)) {
                String deleteLink = "${createLink(controller: 'resource', action: 'delete', params: [id: attrs.id])}"
                out << "<a href=$deleteLink>Delete</a>"
            }
        }
    }


    def showSubscribe = { attrs, body ->
        if (session.user) {
            Long topicID = attrs.topicID
            println(topicID)
            if (topicID) {
                if (session.user.isSubscribed(topicID)) {
                    out << "<a href='javascript:void(0)' data-id=$topicID  class='unsubscribe'>Un-Subscribe</a>"
                } else {
                    out << "<a href='${createLink(controller: 'subscription', action: 'save', params: [id: topicID])}'>Subscribe</a>"
                }
            }
        }
    }
    def subscriptionCount = { attrs, body ->
        Long userId = attrs.userId
        Long topicId = attrs.topicId
        if (userId) {
            out << Subscription.countByUser(User.load(userId))

        }
        if (topicId) {
            out << Subscription.countByTopic(Topic.load(topicId))

        }
    }

    def resourceCount = { attrs, body ->
        Long topicId = attrs.topicId
        if (topicId) {
            out << Resource.countByTopic(Topic.load(topicId))
        }
    }

    def topicCount = { attrs, body ->
        Long userId = session.user.id
        if (userId) {
            out << Topic.countByCreatedBy(User.load(userId))
        }
    }

//    def topPosts = {
//        List<Resource> resourceList = Resource.getTopPosts()
//        out << render(template: "/login/topPost", model: [resourceList: resourceList])
//    }


    def trendingTopics = {
        if (session.user) {
            List<Topic> trendingTopicList = Topic.getTrendingTopics()
            out << render(template: "/user/trendingTopics", model: [trendingTopicList: trendingTopicList])
        }
    }
    def userImage = { attrs, body ->
        Long userId = attrs.id
        if (userId) {
            String src = "/user/image/${userId}"
            out << "<img src=${src} class='img img-thumbnail img-responsive' width='75px' height='75px'>"
        }


    }


}
