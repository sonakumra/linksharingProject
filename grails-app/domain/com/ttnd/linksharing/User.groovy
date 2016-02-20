package com.ttnd.linksharing

class User {
    String email;
    String username;
    String password;
    String firstName;
    String lastName;
    byte[] photo;
    Boolean admin;
    Boolean active;
    Date lastUpdated;
    Date dateCreated;

    static transients = ['name']


    static constraints = {
        email unique: true , email: true, blank: false
        password blank:false,minSize: 5
        firstName blank: false
        lastName blank: false
        admin nullable: true
        active nullable: true
        photo nullable: true
        username blank:false


    }
    static  hasMany =[topics:Topic, subscribtion:Subscription,
                      readingItems:ReadingItem,resources:Resources]
    String getName()
    {
        [this.firstName,this.lastName].join(' ')

    }
    String toString(){
        return username
    }

    static mapping = {
        photo sqlType: 'longblob'
    }
}
