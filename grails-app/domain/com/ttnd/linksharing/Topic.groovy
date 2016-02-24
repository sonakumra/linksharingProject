package com.ttnd.linksharing

import com.ttnd.linksharing.vo.TopicVO

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

    static hasMany = [subsciptions:Subscription,resources:Resource]

    def afterInsert() {
        Topic.withNewSession {
            Subscription subscription = new Subscription(user:createdBy, topic: this, seriousness: Seriousness.VERY_SERIOUS)
            subscription.save()
        }

    }
    String toString()
    {
        return name

    }
    static mapping = {
        sort name:'asc'
    }
     static  List<TopicVO> getTrendingTopics() {
         List result = Account.createCriteria().list() {
             projections {
                 createAlias("branch", "b")
                 groupProperty("b.id")
                 property("b.name")
                 sum("balance", 'totalBalance')
             }
             order("totalBalance", "desc")
             order("b.name", "desc")
         }
         render "Result -> ${result}"



        new TopicVO()
    }

}






