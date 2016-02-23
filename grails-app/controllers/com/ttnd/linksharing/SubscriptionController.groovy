package com.ttnd.linksharing

import grails.transaction.Transactional


class SubscriptionController {


    @Transactional
    def index() {
        ////deleteSubscription(10)
       // render text: 'ok'
       //saveSubscription(1)
       render text: 'oky'

    }


    def deleteSubscription(long id) {
        def subscription = Subscription.get(id)
        if (subscription) {
            subscription.delete(flush: true)
            flash.message = "Deletion successfull"
            render flash.message
        } else{
            flash.error = "subscription could not be deleted"
            render "~FAILURE~"
        }

    }

    def saveSubscription(long id) { //?????
        //Seriousness seriousness = Seriousness.valueOf(params.seriousness as String)
        render "hello"
        def topic = Topic.read(id)
        User user = session.user
        Subscription subscription = new Subscription(topic: topic, user: user, seriousness:Seriousness.SERIOUS)
        //ask last
        if (subscription.validate() && subscription.save(flush: true,failOnError: true)) {
            flash.message = "Successful"
            render flash.message
        } else{
            flash.error = "subscription could not be saved"
            render "~FAILURE~"
        }


    }

   def updateSubscription(Integer id,String serious)
   {
           Subscription subscription = Subscription.get(id)

           Seriousness seriousness = Seriousness.getSeriousness(serious)


           if(subscription && seriousness)
           {
               subscription.seriousness = seriousness

               if(subscription.validate() && subscription.save(flush: true,failOnError: true))
                   render "Subscription ${subscription} saved successfully"
               else
                   render "Subscription ${subscription} could not be saved"
           }
           else
           {
               render "Subscription with id ${id} could not be found."
           }
       }
   }





