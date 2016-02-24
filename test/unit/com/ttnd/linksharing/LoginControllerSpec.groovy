package com.ttnd.linksharing

import grails.test.mixin.TestFor
import org.springframework.stereotype.Controller
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LoginController)
class LoginControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    }

    void "when user is available for login"() {
        setup: ""
        User user = new User(firstName: "sona", lastName: "kumra", email: "sona@tothenew.com", password: Constants.PASSWORD, username: "sona", confirmPassword: Constants.PASSWORD)
        session.user = user
        when: ""
        controller.index()
        then: ""
        response.forwardedUrl == "/user/index"

    }

    void "when user is not available"() {
        when: ""
        controller.index()
        then: ""
        response.text == "Sorry,. Please try again."

    }
    void "login handler when user login "(){
        setup:"user is active"
        User user = new User(firstName:"sona", lastName:"kumra", email: "sona@tothenew.com", password:Constants.PASSWORD, username:"sona",confirmPassword:Constants.PASSWORD,active:true  )
        user.save(validate:false,flush:true)
        when:""
        controller.loginHandler(user.firstName,user.password)
        then:""
        //session.user==user
        response.redirectedUrl=='/'
    }
    void "user logout"(){
        setup:""
        User user = new User(firstName: "sona", lastName: "kumra", email: "sona@tothenew.com", password: Constants.PASSWORD, username: "sona", confirmPassword: Constants.PASSWORD)
        session.user = user

        when:""
        controller.logout()

        then:""
        //flash.message == "Goodbye"
        session.user==null
        response.forwardedUrl=="/login/index"



    }
}
