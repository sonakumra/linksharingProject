package com.ttnd.linksharing



class Subscription {
    Topic topic
    User user
    Seriousness seriousness
    Date dateCreated



    static constraints = {user unique:'topic'
    }
    static  belongsTo = [user:User]
}
