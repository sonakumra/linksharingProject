package com.ttnd.linksharing

class UserController {

    def index(long id) {
        render "hello"
        //def user = User.get(id)
        User user = session.user
        render "User DashBoard ${session} ${user} ${user.username}"
        //register()
    }

    def register() {

        User user = new User(email: params.email, username: params.username, firstName: params.firstName, lastName: params.lastName, password: params.password, confirmPassword: params.confirmPassword)
        //  User user=new User(username: "user",firstName: "user1",lastName: "lname",email: "a@b.com",password: Constants.PASSWORD,confirmPassword: Constants.PASSWORD,active: true)
        if (user.validate() && user.save(flush: true, failOnError: true)) {
            flash.message = "Successful registration"
            render flash.message
        } else {
            flash.error = " user could not be registered"
            render "~FAILURE~"
        }


    }
}
