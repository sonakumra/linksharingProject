<%--
  Created by IntelliJ IDEA.
  User: sona
  Date: 10/3/16
  Time: 12:56 PM
--%>

<!DOCTYPE html>
<html>
<head>
  <title><g:if env="development">Grails !!</g:if><g:else>Error</g:else></title>
  <meta name="layout" content="main">
  <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
</head>
<body>
<g:if env="development">
  <p>RESOURCE NOT FOUND</p>
  <g:renderException exception="${exception}" />
</g:if>
<g:else>
  <ul class="errors">
    <li>An error has occurred</li>
  </ul>
</g:else>
</body>
</html>
