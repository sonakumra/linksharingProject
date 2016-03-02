package com.ttnd.linksharing

class PersonController {

    def index() {}
    def actionArguments(String name,int age)
    {
        render params.name
        render params.age
    }

    def paramConvention()
    {
        render params.name
        render params.age
        render params.properties
    }
    def paramConversion()
    {
        float age=params.float("age")
        render age
    }
    def Example()
    {
        render "${params.properties}"  //treat properties as keys how to make it accessible from this
        render "${ params.getProperties()}"
    }
    def databindingWithErrors(){
        def b = new Person(params)
        println b.hasErrors()
        if(b.hasErrors()){
            println "the value ${b.errors.getFieldError('age')}"
            if(b.errors.getFieldError("age")){
                println b.errors.getFieldError("age").rejectedValue

            }
        }
        render b.properties
    }


}


