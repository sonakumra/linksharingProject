package com.ttnd.linksharing

import com.ttnd.linksharing.vo.ResourceVo

import javax.websocket.Session

class LoginController {

    def index() {
        //User user = User.findByUsernameAndPassword(params.username,params.password)
        if(session.user){
            User user=session.user
            forward(controller:'user',action: 'index')


        }else {
            flash.message = "Sorry,. Please try again."


                List<Resource> result = Resource.getTopPosts()
                List<Resource> recentShare=Resource.list([sort:'dateCreated',order:'desc',max:2 ])

                 render (view:'index',model:[result:result,recentShares:recentShare])


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
