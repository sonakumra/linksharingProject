package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

  /*  void "validate topic name is unique per user"() {
        setup: "user created topic"
        String topicName = "grails"
        User user = new User(firstName: "sona", lastName: "Kumra", email: "a@b.com", password: "qwerty", username: "abc")
        Topic topic = new Topic(name: topicName, visibility: Visibility.PRIVATE, createdBy: user)



        when:
        topic.save()

        then:
        topic.count() == 1

        when:
        Topic topicNew = new Topic(name: topicName, visibility: Visibility.PUBLIC, createdBy: user)
        topicNew.save()

        then:
        topic.count() == 1
        topicNew.errors.allErrors.size() == 1
        topicNew.errors.getFieldErrorCount('name') == 1


    }*/

    void "visibility should not be null and must be from enum "() {
        setup: "user created topic"
        User user = new User(firstName: "sona", lastName: "Kumra", email: "a@b.com", password: "qwerty", username: "abc")
        Topic topic = new Topic(name: name, visibility: visibility, createdBy: user)

        when: "check for valiation"
        Boolean result = topic.validate()

        then: "test the result"
        result == valid

        where: "trying different values"

        sno | name | visibility | valid
        1 | "grails" | " " | false
        2 | "java" | null | false
        3 | "grails" | Visibility.PRIVATE | true
        4 | "grails" | Visibility.PUBLIC | true
        5 | "grails" | "xyz" | false


    }
   def "Checking toString method"() {
        setup:
        Topic topic = new Topic(name: topicName, visibility:Visibility.PUBLIC)
        when:
        String result = topic.toString()

        then:
        result == resultant

        where:
        topicName | resultant
        "Groovy"  | "Groovy"
        null      | null

    }

}
