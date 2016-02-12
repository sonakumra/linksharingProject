package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ResourceRating)
class ResourceRatingSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        setup: "user giving rating to resource"
        User user = new User(firstName: "sona", lastName: "kumra", email: "a@b.com", password: "123456", username: "sona")
        Topic topic = new Topic(name: "grails", visibility: Visibility.PUBLIC, createdBy: user)
        LinkResource linkResource = new LinkResource(description: " this is helpfull", createdBy: user, topic: topic, url: "http://grails.github.io/grails-doc/2.5.1/ref/Constraints/url.html")
        ResourceRating resourceRating = new ResourceRating(resources: linkResource, user: user, score: value)
        println " hello"

        when: "check for valiation"
        Boolean result = resourceRating.validate()

        then: "test the result"
        result == valid

        where: "trying different values"
        sno | value | valid
        1 | 0 | false
        2 | 7 | false
        3 | 4 | true


    }
    void "user unique resource "(){
        setup: "user rated resource"
        User user = new User(firstName: "sona", lastName: "Kumra", email: "a@b.com", password: "qwerty", username: "abc")
        LinkResource linkResource = new LinkResource(description: " this is helpfull", createdBy: user, topic:"grails", url: "http://grails.github.io/grails-doc/2.5.1/ref/Constraints/url.html")
        ResourceRating resourceRating = new ResourceRating(resources: linkResource, user: user, score:5)

        when:
        resourceRating.save ( )

        then:
        resourceRating.count ( ) == 1

        when:
        ResourceRating resourceRatingNew = new ResourceRating(resources: linkResource, user: user, score:5)
        resourceRatingNew.save ( )

        then:
        resourceRating.count ( ) == 1
        resourceRatingNew.errors.allErrors.size ( ) == 1
        resourceRatingNew.errors.getFieldErrorCount ( 'user' ) == 1
    }



}
