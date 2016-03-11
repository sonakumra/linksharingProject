import com.ttnd.linksharing.LoginController

class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //"/"(view:"/index")
        "404"(view: '/my404')
        "500"(view:'/error')
        "/"(view: 'index',controller: 'login', action: 'index')
       // "/"(controller: "login", action: "index")

	}
}
