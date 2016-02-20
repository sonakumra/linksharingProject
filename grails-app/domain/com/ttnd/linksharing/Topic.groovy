package com.ttnd.linksharing

class Topic {
    String name;
    Date dateCreated;
    Date lastUpdated;
    Visibility visibility
    User createdBy



    static constraints = {
        name blank: false,unique:'createdBy'
       visibility(inlist: Visibility.values() as List );
    }

    static hasMany = [subsciptions:Subscription,resources:Resources]
    String toString(){
        return name
    }
    def afterInsert() {
        Topic.withNewSession {
            Subscription subscription = new Subscription(user:createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS)
            subscription.save()
        }

    }


}

