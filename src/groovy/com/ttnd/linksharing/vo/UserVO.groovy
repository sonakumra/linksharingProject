package com.ttnd.linksharing.vo

import org.apache.commons.lang.Validate
import org.apache.ivy.core.settings.Validatable


class UserVO {
 Long userId
 String fname
 String userName
 String lname
 String email
 def image
 boolean isActive
 boolean isAdmin
}

