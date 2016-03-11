package com.ttnd.linksharing.co

import grails.validation.Validateable




@Validateable
class UserCO {
    String username
    String password
    String firstName
    String lastName
    String email
    String confirmPassword

    static constraints = {
        email(unique: true, blank: false, email: true)
        password(blank: false, minSize: 5)
        firstName(blank: false)
        lastName(blank: false)
        username(blank: false, unique: true)
        confirmPassword(bindable: true, nullable: true, blank: true, validator: { val, obj ->
            if (obj.password != val || !val || !obj.password) {
                return 'password.do.not.match.confirm.password'
            }
        })
    }

}
