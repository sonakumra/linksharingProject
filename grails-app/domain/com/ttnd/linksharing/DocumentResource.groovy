package com.ttnd.linksharing

class DocumentResource extends Resource {
    String filePath

    static constraints = {
    }
    String toString(){
        return "${filePath}"
    }

}
