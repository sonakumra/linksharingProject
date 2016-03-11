package com.ttnd.linksharing



class Subscription {
    Topic topic
    User user
    Seriousness seriousness="SERIOUS"
    Date dateCreated



    static constraints = {user unique:'topic'
    }
    static  belongsTo = [user:User]
    String toString(){
        return "${user} subscribed ${topic}"
    }
    void some(){
        user.topics
    }

     static List<Topic> getSubscribedTopic(User user){
        List<Topic> result = Subscription.createCriteria().list{
            projections{
                property('topic')

            }
            eq('user',user)
        }
        return result


    }


}
