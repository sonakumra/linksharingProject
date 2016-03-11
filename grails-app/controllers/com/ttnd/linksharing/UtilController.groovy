package com.ttnd.linksharing

class UtilController {

    def index() {
        if(log.isInfoEnabled())
        log.info("Sample Info")
        if(log.isErrorEnabled())
        log.error("Sample Error")
        if(log.isWarnEnabled())
        log.warn("Sample Warn")
        if(log.isFatalEnabled())
        log.fatal("Sample Fatal")

        render view: 'form'
    }
    def save(User user)
    {
        if(user?.hasErrors()){
            render view: 'form', model: [user: user ]
        }else {
            user.save()
            render 'user saved'
        }

    }
    def testMail(){

        sendMail {
            to "sona@tothenew.com"
            subject "Hello Fred"
            body 'How are you?'
        }
    }

    def try1(){
     render params
    }

}

