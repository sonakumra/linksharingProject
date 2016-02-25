package com.ttnd.linksharing
import com.ttnd.linksharing.Resource

class TestController {

    def index() { }
    def show(){
        List result = Resource.createCriteria().list {
            projections {
                createAlias("topic", "t")
                groupProperty("t.id")
                property("t.name")
                property("t.visibility")
                count("id", 'totalResources')
                property("t.createdBy")
            }
            eq("t.visibility",Visibility.PUBLIC)
            order("totalResources", "desc")
            order("t.name", "desc")
            maxResults 5
            firstResult 0
        }
        render "Result -> ${result}"
    }
    def IsRead() {
        ReadingItem item = ReadingItem.get(1)
        // String firstName = user.firstName
        ReadingItem.executeUpdate("update ReadingItem as rt set rt.isRead=:isRead where rt.id=:id", [isRead:true, id: 1.toLong()])
        item.refresh()
        render "After updation ${item.isRead}"
        // User.executeUpdate("delete User where id=:id", [id: 1.toLong()])
        // render "Success"
    }

}


