<%--
  Created by IntelliJ IDEA.
  User: sona
  Date: 3/3/16
  Time: 5:04 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="application">

    <title></title>

</head>

<body>
<div class="row">

<div class="col-xs-6">
    <div class="row" style="margin:9px">
        <g:render template="showTopic" model="[topics:topic]"/>
    </div>
    <div class="row" style="margin:9px">
        <g:render template="showUser" model="[subscribedUsers:subscribedUsers]"/>
    </div>
</div>

<div class="col-xs-6">
    <g:render template="showPost" model="[topics:topic]"/>
</div>
    </div>

</body>
</html>