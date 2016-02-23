package com.ttnd.linksharing

class ReadingItem {

    Resource resources
    User user
    Boolean isRead
    static constraints = {
        resources unique: 'user'
    }
    static belongsTo = [resources:Resource]

}
