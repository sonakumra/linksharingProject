package com.ttnd.linksharing

class Topic {
    String name;
    Date dateCreated;
    Date lastUpdated;
    Visibility visibility
    User createdBy



    static constraints = {
        name blank: false,unique:'createdBy'
       // visibility(inlist: visibility.values() as List); //ask
    }
    static belongsTo = [createdBy:User]
    static hasMany = [subsciptions:Subscription,resources:Resources]
}
