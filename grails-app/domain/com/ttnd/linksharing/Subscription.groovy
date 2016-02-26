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

     static List getSubscribedTopic(User user){
        List result = Subscription.createCriteria().list{
             user=User.findByUsername(user)
            projections{
                property('topic')

            }
            eq('user',user)
        }
        return result


    }

}
