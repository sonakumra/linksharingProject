package com.ttnd.linksharing

class UserController {

    def index(int id) {
        def user = User.get(id)
        render "User DashBoard ${session} ${user} ${user.username}"
    }

    def register() {
        User user = new User(email: params.email, username: params.username, firstName: params.firstName, lastName: params.lastName, password: params.password)
        if(user.validate() && user.save()){
            flash.message="Successful registration"
            render flash.message
        } else if (user.hasErrors()) {
            errors.allErrors.each {
                render "${it}"
            }
        }


    }
}
