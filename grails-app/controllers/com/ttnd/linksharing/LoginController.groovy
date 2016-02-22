package com.ttnd.linksharing

import javax.websocket.Session

class LoginController {

    def index() {
        User user = User.findByUsernameAndPassword(params.username,params.password)
        if(session.user){
            flash.message = "Hello ${user.firstName}!"
            redirect(controller:UserController)
        }else{
            flash.message = "Sorry, ${params.username}. Please try again."

        }
    }
    def loginHandler(String username,String password){
        User user = User.findByUsernameAndPassword(params.username,params.password)
        if(user) {
            if (user.active) {
                session.user = user
                redirect(controller: LoginController, action: index())
            } else {
                flash.error = 'Your accoutn is not active'

            }
        }
        else{
            flash.error='User not found'
            render(flash.error)

        }




    }
    def logout(){
        flash.message = "Goodbye ${session.user.username}"
        session.invalidate()
        redirect(controller: 'Login' , action:'index')

    }
}
