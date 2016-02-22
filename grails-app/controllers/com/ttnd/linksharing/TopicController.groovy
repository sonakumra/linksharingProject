package com.ttnd.linksharing

class TopicController {

    def index() { }

    def show(int id){
        Topic topic = Topic.get(id)

        if(topic){
            if(topic.visibility== Visibility.PUBLIC){
                render("Succes")
            }else if(topic.visibility== Visibility.PRIVATE){
                User user = session["user"]
                Subscription subscription = Subscription.findByTopicAndUser(topic,user)
                if(subscription){
                    render("Success")
                }else{
                    flash.error="Not a Subscribed User"
                    redirect(controller:"Login " ,action:"index")
                }
            }
        }else{
            flash.error="Topic does not exist"
            redirect(controller:'Login' ,action:'index' )
        }
    }
}
