package com.ttnd.linksharing

class DocumentResource extends Resource {
    String filePath
    String fileName
    String contentType
    static transients = ['contentType', 'fileName']
    static constraints = {
        filePath(blank: false)
        fileName(bindable:true,nullable:true,blank:true)
        contentType(bindable: true, blank: false, validator: { val, obj ->
            return val.equals(Constants.DOCUMENT_CONTENT_TYPE)
        })
    }



    String toString(){
        filePath
    }

}
