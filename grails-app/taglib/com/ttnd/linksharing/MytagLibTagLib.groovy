package com.ttnd.linksharing

class MytagLibTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "tl"
    def showAdmin={attrs,body->
       Boolean isAdmin = Boolean.valueOf(attrs.isAdmin)
       if(isAdmin){
           out<<body()
    }
}
    def showList={
        List<User> users=[]
        /*for(int i=1;i<=2;i++){
            users.add(User.get(i as Long))
        }*/
        users=User.list()

        out<<render(template: '/userlist',model:[users:users])

    }

}
