package com.ttnd.linksharing

class ReadingItemController {

    def index() {}

    def changeIsRead(Long id, Boolean isRead) {
        Resource resource = Resource.get(id)
        User user = session.user

        if (ReadingItem.executeUpdate("update ReadingItem as r set r.isRead=:isRead where r.resources.id=id and r.user.id = :userId", [isRead: isRead, userId: user.id])) {
            render "Reading Item isRead successfully changed. ~SUCCESS~"
        } else {
            render "Reading Item isRead could not be changed. ~FAILURE~"
        }
    }
}
