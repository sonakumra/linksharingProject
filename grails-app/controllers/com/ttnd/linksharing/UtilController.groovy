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
    }
}
