package com.ttnd.linksharing

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test username and email"() {
        setup: "user creating email"
        User user = new User()

        when: "check for valiation"
        Boolean result = user.validate()

        then: "test the result"
        result == valid

        where: "trying different values"
        sno | firstName | lastName | email | password | valid
        1 | " " | "hello" | "a@b.com" | "123456" | false
        2 | "sona" | "hello" | "sona" | "12345" | false
        3 | "sona" | "hello" | "sona" | "12345" | false
        4 | "hello" | "hello" | "a@b.com" | "12345" | true


    }
}
