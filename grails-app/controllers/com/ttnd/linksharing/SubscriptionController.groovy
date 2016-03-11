package com.ttnd.linksharing

import grails.converters.JSON
import grails.transaction.Transactional


class SubscriptionController {


    @Transactional
    def index() {
        ////deleteSubscription(10)
        // render text: 'ok'
        //saveSubscription(1)
        render text: 'oky'

    }


    def delete(long id) {
        Topic topic = Topic.load(id)
        println(params)
        User user = session.user
        Map jsonResponseMap = [:]
        if (user.isSubscribed(topic.id)) {
            Subscription subscription = Subscription.findByUserAndTopic(session.user, topic)
            if (subscription) {
                subscription.delete(flush: true)
                jsonResponseMap.message = "Deletion successfull"

            } else {
                jsonResponseMap.error = "subscription could not be deleted"
            }

        }
        jsonResponseMap.id = id;
        JSON jsonResponse = jsonResponseMap as JSON
        render jsonResponse

    }

    def save(long id) {
        //Seriousness seriousness = Seriousness.valueOf(params.seriousness as String)
        def topic = Topic.read(id)
        User user = session.user
        Subscription subscription1 = Subscription.findByUserAndTopic(session.user, topic)
        if (!subscription1) {
            Subscription subscription = new Subscription(topic: topic, user: user, seriousness: Seriousness.SERIOUS)
            if (subscription.validate() && subscription.save(flush: true, failOnError: true)) {
                flash.message = "Successful"
                render flash.message
            } else {
                flash.error = "subscription could not be saved"
                render "~FAILURE~"
            }
        }


    }


    def update(Integer id, String serious) {
        Subscription subscription = Subscription.get(id)

        Seriousness seriousness = Seriousness.getSeriousness(serious)

        Map jsonResponseMap = [:]
        if (subscription && seriousness) {
            subscription.seriousness = seriousness

            if (subscription.validate() && subscription.save(flush: true, failOnError: true))
                jsonResponseMap.message = "Subscription ${subscription} saved successfully"
            else
                jsonResponseMap.error = "Subscription ${subscription} could not be saved"
        } else {
            jsonResponseMap.error = "Subscription with id ${id} could not be found."
        }
        JSON jsonResponse = jsonResponseMap as JSON
        render jsonResponse
    }
}





