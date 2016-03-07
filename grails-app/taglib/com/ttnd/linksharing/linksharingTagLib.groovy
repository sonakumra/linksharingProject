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
            out << "<a href=${attrs.filePath}>Download</a>"
        } else {
            out << "<a href=${attrs.url} target='_blank'>View full site</a>"
        }
    }
    def resourceDelete = { attrs, body ->
        Long rId = attrs.id
        if (User.canDeleteResource(session.user, rId)) {
            out << "Delete"
        }
    }

}
