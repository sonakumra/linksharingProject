<div class="panel panel-default">
    <div class="panel-heading">
        Register
    </div>

    <div class="panel-body">
        <g:uploadForm class="form" controller="user" action="register" method="post">
            <g:hasErrors bean="${user}">
                <div class="alert alert-danger">
                    <g:eachError><g:message error="${it}"/></g:eachError>
                </div>
            </g:hasErrors>

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
                                <g:textField type="text" id="firstname" name="firstName" value="${user?.firstName}"/>
                            </div>

                            <div class="alert-danger" role="alert">
                                <g:fieldError field="firstName" bean="${user}"/>
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
                    </tr>N
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
                                <input type="file" id="photo" name="file" value="Browse">
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <div class="form-group">
                                <g:submitButton name="submit" type="submit" class="btn btn-default btn-primary"
                                                id="loginBtn" value="Login"/>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </g:uploadForm>
    </div>
</div>
