package com.ttnd.linksharing

class ReadingItem {

    Resources resources
    User user
    Boolean isRead
    static constraints = {
        resources unique: 'user'
    }

}
