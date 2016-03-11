<%--
  Created by IntelliJ IDEA.
  User: sona
  Date: 24/2/16
  Time: 9:52 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Linksharing"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <asset:javascript src="jquery.js"/>
    <asset:javascript src="bootstrap.min.js"/>
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="bootstrap-theme.min.css"/>
    <asset:stylesheet src="font-awesome.min.css"/>



    <g:layoutHead/>
</head>
<body>
<g:render template="/topic/create"/>
<g:render template="/resource/linkCreate"/>
<g:render template="/resource/documentCreate"/>
<g:render template="/user/forgetPassword"/>
<nav class="navbar">
    <div class="container" style="border:2px solid black;border-radius:25px;">
        <div class="row">
            <div class="col-md-4">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><ins>Link Sharing</ins></a>
                </div>
            </div>
            <div class="col-md-3">
                <form class="navbar-form navbar-right" style="border:2px solid black;border-radius:25px;">
                    <div class="input-group">
                        <span class="input-group-btn">
                            <button class="btn" style="background-color:transparent;">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </span>
                        <input type="text" class="form-control" placeholder="Search" style="background-color:transparent;">
                        <span class="input-group-btn">
                            <button class="btn" style="background-color:transparent;">
                                <span class="glyphicon glyphicon-remove"></span></button>
                        </span>
                    </div>
                </form>
            </div>
            <g:if test="${session.user}">
            <div class="col-md-1">
                    <a class="btn" role="button" data-toggle="modal" data-target="#createtopicModal">
                    <span class="fa fa-weixin"></span>
                </a>
            </div>
            <div class="col-md-1">
                <a class="btn" role="button" data-toggle="modal" data-target="#sendinviteModal">
                    <span class="glyphicon glyphicon-envelope"></span>
                </a>
            </div>
            <div class="col-md-1">
                <a class="btn" role="button" data-toggle="modal" data-target="#sharelinkModal">
                    <span class="fa fa-link"></span>
                </a>
            </div>
            <div class="col-md-1">
                <a class="btn" role="button" data-toggle="modal" data-target="#sharedocModal">
                    <span class="fa fa-file-o"></span>
                </a>
            </div>
            <div class="col-md-1">
                <div class="dropdown">
                    <a class="btn dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>Uday
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Users</a></li>
                        <li><a href="#">Topics</a></li>
                        <li><a href="#">Posts</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </div>
            </g:if>

            </div>
    </div>
        </div>
</nav>


%{--<div class="container">--}%
    %{--<g:if test="${flash.message}">--}%

    %{--</g:if>--}%
    %{--<g:if test="${flash.error}">--}%

    %{--</g:if>--}%

    <div class="container">
       <div class = "jsonResponse" style="display:none"></div>
    </div>

    <g:layoutBody/>
</div>


<asset:javascript src="jquery.validate.min.js"/>
<asset:javascript src="application.js"/>
</body>
</html>