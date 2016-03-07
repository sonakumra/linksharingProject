package com.ttnd.linksharing

class ReadingItem {

    Resource resources
    User user
    Boolean isRead
    static constraints = {
        resources unique: 'user'
    }
    static belongsTo = [resources: Resource]

    static def getResourceDetails(User user){

     def result = ReadingItem.createCriteria().list{
            projections{
                property('resources.id')
                property('isRead')
                'resources'{
                    property('url')
                    property('filePath')
                }
            }
            eq('user',user)
        }
        return result

    }

}
