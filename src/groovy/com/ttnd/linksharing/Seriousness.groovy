package com.ttnd.linksharing

enum Seriousness {
    SERIOUS,
    VERY_SERIOUS,
    CASUAL

    static getSeriousness(String serious) {

        String seriousInUpperCase = serious.toUpperCase()
        return valueOf(seriousInUpperCase)

    }
}
