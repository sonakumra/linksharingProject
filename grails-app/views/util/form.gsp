<%--
  Created by IntelliJ IDEA.
  User: sona
  Date: 25/2/16
  Time: 12:41 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<g:renderErrors bean="${user}" field="firstName"></g:renderErrors>

<g:form action="save">
    name: <g:textField name="firstName" value="${user?.firstName}"/><br>
    password :<g:passwordField name="password" value="${user?.password}"/><br>
    <g:submitButton name="submit"></g:submitButton>
</g:form>
<tl:showAdmin isAdmin="true"> this is only visible</tl:showAdmin>
<tl:showAdmin isAdmin="false"> not visible</tl:showAdmin>
<tl:showList/>


</body>
</html>