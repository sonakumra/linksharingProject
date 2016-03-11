package com.ttnd.linksharing

import grails.converters.JSON

class ReadingItemController {

    def index() {}

    def changeIsRead(Long id, Boolean isRead) {
        Resource resource = Resource.get(id)
        User user = session.user
       Map jsonObject =[:]


        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead where r.resources.id=:id and r.user.id = :userId", [isRead: isRead, userId: user.id,id:resource.id])) {
            jsonObject.message= "Reading Item isRead successfully changed. ~SUCCESS~"
        } else {
            jsonObject.error="Reading Item isRead could not be changed. ~FAILURE~"
        }
        render jsonObject as JSON
    }
}
