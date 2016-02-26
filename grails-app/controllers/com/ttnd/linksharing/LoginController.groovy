package com.ttnd.linksharing

import javax.websocket.Session

class LoginController {

    def index() {
        //User user = User.findByUsernameAndPassword(params.username,params.password)
        if(session.user){
            User user=session.user
            //flash.message = "Hello ${user.firstName}!"
            forward(controller:'user',action: 'index')
        }else {
            flash.message = "Sorry,. Please try again."
//            render flash.message
//
                List<Resource> result = Resource.getTopPosts()
                render (view:'index',model:[result:result])

//
//            render result
        }
    }
    def loginHandler(String username,String password){
        User user = User.findByUsernameAndPassword(username,password)
        if(user) {
            if (user.active) {
                session.user = user
                redirect(controller:'login', action: 'index')
            } else {
                flash.error = 'Your accoutn is not active'
                render "failure"

            }
        }
        else{
            flash.error='User not found'
            render(flash.error)

        }




    }
    def logout(){
        flash.message = "Goodbye"
        session.invalidate()
        forward( action:'index')

    }
}
