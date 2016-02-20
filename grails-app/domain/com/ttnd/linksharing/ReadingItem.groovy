package com.ttnd.linksharing

class ReadingItem {

    Resources resources
    User user
    Boolean isRead
    static constraints = {
        resources unique: 'user'
    }


    public static ReadingItem save(ReadingItem readingItem) {
        readingItem.validate()
        if (readingItem.hasErrors()) {
            readingItem.errors.each {
                log.error "error while saving readingItem ${it.allErrors}"
            }
            return null
        } else {
            readingItem.save(flush: true)
            return readingItem
        }
    }
}
