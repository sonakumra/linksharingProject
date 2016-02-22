package com.ttnd.linksharing

class DocumentResource extends Resources {
    String filePath

    static constraints = {
    }
    String toString(){
        return "${filePath}"
    }

}
