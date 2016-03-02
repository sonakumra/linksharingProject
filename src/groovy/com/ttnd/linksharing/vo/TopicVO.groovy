package com.ttnd.linksharing.vo

import com.ttnd.linksharing.User
import com.ttnd.linksharing.Visibility

class TopicVO {
    Long id
    String name
    Visibility visibility
    Integer count
    User createdBy
    String toString(){
        return "${id},${name},${visibility},${count},${createdBy}"
    }
}
