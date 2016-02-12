class BootStrap {
    def grailsApplication

    def init = { servletContext ->
        println(grailsApplication.config.grails.sample)
    }
    def destroy = {
    }
}
