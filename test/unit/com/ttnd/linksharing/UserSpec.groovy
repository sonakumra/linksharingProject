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
        User user = new User(firstName: firstName, lastName: lastName, email: email, password: password, username: username)

        println " hello"

        when: "check for valiation"
        Boolean result = user.validate()

        then: "test the result"

        result == valid

        where: "trying different values"
        sno | username | firstName | lastName | email | password | valid
        1 | "sona" | "abc" | "xyz" | "sona@yahoo.com" | "qwertyw" | true
        2 | " " | "abc" | "xyz" | "sona@yahoo.com" | "qwertyw" | false
        3 | "sona" | " " | "xyz" | "sona@yahoo.com" | "qwertyw" | false
        4 | "sona" | "abc" | " " | "sona@yahoo.com" | "qwertyw" | false
        5 | "sona" | "abc" | "xyz" | " " | "qwertyw" | false
        6 | "sona" | "abc" | "xyz" | "sona@yahoo.com" | " " | false
        7 | null | "abc" | "xyz" | "sona@yahoo.com" | "qwertyw" | false
        8 | "sona" | null | "xyz" | "sona@yahoo.com" | "qwertyw" | false
        9 | "sona" | "abc" | "xyz" | null | "qwertyw" | false
        10 | "sona" | "abc" | "xyz" | "abc" | "qwerty" | false
        11 | "sona" | "abc" | "xyz" | "sona@yahoo.com" | " 1236" | false
        12 | "sona" | "abc" | "xyz" | "sona@yahoo.com" | null | false


    }

    def "check email should be unique"() {
        setup:
        String email = "sona@tothenew.com"
        String password = 'password'
        User user = new User(firstName: "sona", lastName: "Kumra", email: email, password: password, username: "abc")

        when:
        user.save()

        then:
        user.count() == 1

        when:
        User newUser = new User(firstName: "abc", lastName: "xyz", email: email, password: password, username: "zwy")
        newUser.save()

        then:
        User.count() == 1
        newUser.errors.allErrors.size() == 1
        newUser.errors.getFieldErrorCount('email') == 1
    }
}
