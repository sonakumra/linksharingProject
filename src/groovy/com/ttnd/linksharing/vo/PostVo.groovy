package com.ttnd.linksharing.vo

class PostVo {
    Long resourceID
    Integer resourceRating
    String description
    String url
    String filePath
    byte[] userPhoto
    boolean isRead
    String topicName
    String userUserName
    String userFirstName
    String userLastName

    String getNameOfUser(){
        return "$userFirstName $userLastName"
    }
}

