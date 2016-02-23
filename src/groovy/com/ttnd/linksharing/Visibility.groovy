package com.ttnd.linksharing

enum Visibility {
    PUBLIC, PRIVATE

    static Visibility getEnum(String visibility) {

        String visibilityInUpperCase = visibility.toUpperCase()
        return valueOf(visibilityInUpperCase)


    }
}