package com.ttnd.linksharing

class linksharingTagLib {
    static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace ="ls"

    def MarkRead = { attrs, body ->
        User user = session.user
        if (user) {
            if (attrs.isRead) {
                out << "mark as unread"
            } else {
                out << "mark as read"
            }


        }
    }
}
