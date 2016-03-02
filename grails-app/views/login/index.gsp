<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="application">

</head>
<body>

<div class="row">
    <div class="col-md-7">
        <div class="row".>
            <div class="panel panel-default">
                <div class="panel-heading">
                    Recent Shares
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3">
                            <img src="#" class="img img-thumbnail img-responsive" alt="Image" id="uimg" style="width:150px;height:150px">
                        </div>
                        <div class="col-md-9 panel">
                            <span class="text-primary">Uday Pratap Singh</span>
                            <span class="text-muted">@uday 5 min</span>
                            <span class="text-primary pull-right">Grails</span>
                            <div class="panel-body text-justify">
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
                            </div>
                            <div class="panel-footer">
                                <a href="#"><span class="fa fa-facebook-square" style="font-size:20px"></span></a>
                                <a href="#"><span class="fa fa-tumblr" style="font-size:20px"></span></a>
                                <a href="#"><span class="fa fa-google-plus" style="font-size:20px"></span></a>
                                <a href="#" class="pull-right">View Post<span class="glyphicon glyphicon-arrow-up"></span></a>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                            <img src="#" class="img img-thumbnail img-responsive" alt="Image" id="uimg" style="width:150px;height:150px">
                        </div>
                        <div class="col-md-9 panel">
                            <span class="text-primary">Uday Pratap Singh</span>
                            <span class="text-muted">@uday 10 min</span>
                            <span class="text-primary pull-right">Grails</span>
                            <div class="panel-body text-justify">
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
                            </div>
                            <div class="panel-footer">
                                <a href="#"><span class="fa fa-facebook-square" style="font-size:20px"></span></a>
                                <a href="#"><span class="fa fa-tumblr" style="font-size:20px"></span></a>
                                <a href="#"><span class="fa fa-google-plus" style="font-size:20px"></span></a>
                                <a href="#" class="pull-right">View Post<span class="glyphicon glyphicon-arrow-up"></span></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Top Posts
                    <div class="pull-right">
                        <div class="dropdown pull right">
                            <button class="dropdown-toggle btn-responsive" data-toggle="dropdown">Today
                                <span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Today</a></li>
                                <li><a href="#">1 Week</a></li>
                                <li><a href="#">1 Month</a></li>
                                <li><a href="#">1 Year</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3">
                            <img src="#" class="img img-thumbnail img-responsive" alt="Image" id="uimg" style="width:150px;height:150px">
                        </div>
                        <div class="col-md-9 panel">
                            <span class="text-primary">Uday Pratap Singh</span>
                            <span class="text-muted">@uday 21 jul 2014</span>
                            <span class="text-primary pull-right">Grails</span>
                            <div class="panel-body text-justify">
                                <g:each in="${result}">
                                    <a href="${it}">${it}</a> <br>
                                </g:each>

                            </div>
                            <div class="panel-footer">
                                <a href="#"><span class="fa fa-facebook-square" style="font-size:20px"></span></a>
                                <a href="#"><span class="fa fa-tumblr" style="font-size:20px"></span></a>
                                <a href="#"><span class="fa fa-google-plus" style="font-size:20px"></span></a>
                                <a href="#" class="pull-right">View Post<span class="glyphicon glyphicon-arrow-up"></span></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-4 col-md-push-1">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Login
                </div>
                <div class="panel-body">
                    <g:form class="form" controller="login" action="loginHandler">
                        <div class="table-responsive">
                            <table class="table-condensed">
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label for="username">UserName *</label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <g:textField id="username" name="username"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label for="password">Password *</label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <g:passwordField id="password" name="password"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <a href="" class="col-xs-4" data-toggle="modal" data-target="#forgotPassword">Forgot Password</a>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <g:submitButton name="submit" class="btn btn-default btn-primary" id="loginBtn" value="Login"/>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </g:form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Register
                </div>
                <div class="panel-body">
                    <g:form class="form" controller="user" action="register" >
                        <div class="table-responsive">
                            <table class="table-condensed">
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label for="firstname">First Name*</label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <g:textField type="text" id="firstname" name="firstName"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label for="lastname">Last Name*</label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <g:textField type="text" id="lastname" name="lastName"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label for="email">E-Mail *</label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <g:field type="email" id="email" name="email"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label for="usernameReg">Username *</label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <g:field type="text" id="usernameReg" name="username"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label for="passwordReg">Password *</label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <g:passwordField type="password" id="passwordReg" name="password"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label for="confirmpassword">Confirm Password *</label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <g:passwordField type="password" id="confirmpassword" name="confirmPassword"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label for="photo">Photo *</label>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="form-group">
                                            <input type="file" id="photo" name="photo" value="Browse">
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <div class="form-group">
                                            <g:submitButton name="submit" type="submit" class="btn btn-default btn-primary" id="loginBtn" value="Login"/>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </g:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
