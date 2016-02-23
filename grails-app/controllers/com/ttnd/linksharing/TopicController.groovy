package com.ttnd.linksharing

class TopicController {

    def index() {}

    def show(Long id) {
        // long id= params.id
        log.info(id)
        Topic topic = Topic.get(id)
        log.info topic
        if (topic) {
            if (topic.visibility == Visibility.PUBLIC) {
                render("Succes")
            } else if (topic.visibility == Visibility.PRIVATE) {
                User user = session["user"]
                Subscription subscription = Subscription.findByTopicAndUser(topic, user)
                if (subscription) {
                    render("Success")
                } else {
                    flash.error = "Not a Subscribed User"
                    redirect(controller: 'login', action: 'index')
                }
            }
        } else {
            flash.error = "Topic does not exist"
            redirect(controller: 'login', action: 'index')
        }
    }

    def save(String topicName, String visibility) {
        User user = session.user
        Topic topic = new Topic(name: topicName, createdBy: user, visibility: Visibility.getEnum(visibility))
        if (topic.validate() && topic.save()) {
            flash.message = "Successful registration"
            render flash.message
        } else {
            flash.error = "topic could not be saved"
            render "~FAILURE~"
        }


    }
}


