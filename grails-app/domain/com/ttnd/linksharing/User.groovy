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
    //String confirmPassword;
    Date lastUpdated;
    Date dateCreated;

    //static transients = ['name','confirmPassword']
   // static transients = ['confirmPassword']


    static constraints = {
        email unique: true , email: true, blank: false
        password blank:false,minSize: 5
        firstName blank: false
        lastName blank: false
        admin nullable: true
        active nullable: true
        photo nullable: true
        username blank:false
      //  confirmPassword(nullable: true, blank: true, validator: { confirmPassword, obj ->
           // Integer id = 0
           // id = obj.getId()
           //// if (!obj.id && obj.password != confirmPassword) {
               // "password.mismatch.confirmPassword"
            //}
       // })


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
