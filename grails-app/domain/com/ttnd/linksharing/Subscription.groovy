package com.ttnd.linksharing
import grails.plugin.cache.SerializableOutputStream

class Subscription {
    Topic topic
    User user
    Date dateCreated
    //Seriousness seriousness;



    static constraints = {user unique:'topic'
    }
    static belongsTo = [user:User,topics:Topic]
}
