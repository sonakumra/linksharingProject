package com.ttnd.linksharing

class ReadingItem {

    Resources resources
    User user
    Boolean isRead
    static constraints = {
        resources unique: 'user'
    }
    static belongsTo = [user:User,resources:Resources,ratings:ResourceRating]
}
