package com.ttnd.linksharing

class LinkResource extends Resources {
    String url

    static constraints = {
        url url: true
    }
    String toString(){
        return "Url is :${url}"
    }

}
