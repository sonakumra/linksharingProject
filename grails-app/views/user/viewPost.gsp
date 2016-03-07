<%--
  Created by IntelliJ IDEA.
  User: sona
  Date: 4/3/16
  Time: 10:06 AM
--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>post</title>

</head>

<body>

<div class="col-md-6 col-md-push-1">
    <div class="panel panel-default" style="border:2px solid black">

        <div class="panel-body">
            <div class="row">
                <div class="col-md-3">
                    <img src="img.png" class="img img-thumbnail img-responsive" alt="Image" id="uimg"
                         style="width:150px;height:150px;border:2px solid black">

                </div>

                <div class="col-md-6 col-md-push-1">

                    <span class="text-primary">Uday Pratap Singh</span>

                    <span class="text-primary pull-right">Grails</span><br>
                    <small>@uday</small>
                    <span class="text-primary pull-right">2.45 PM 22-Feb-2014</span>
                </div>
            </div>

            <div class="row">
                <div class="panel-body text-left">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                    laboris nisi ut aliquip ex ea commodo consequat. Duis
                </div>

            </div>

        </div>

        <div class="panel-footer">
            <a href="#"><span class="fa fa-facebook-square" style="font-size:20px"></span></a>
            <a href="#"><span class="fa fa-tumblr" style="font-size:20px"></span></a>
            <a href="#"><span class="fa fa-google-plus" style="font-size:20px"></span></a>
            <span class="pull-right">
                %{--<a href="#">--}%
                %{--<ins> Delete</ins>--}%
                %{--</a>--}%
                <g:each in="${readingItems}">
                    <%=readingItem%>
                    <g:each in="${it[0][0]}" var="item">
                        <%=item%>
                        <ls:resourceDelete user="${session.user}" id="${item}"/>
                    </g:each>

                </g:each>
            </span>
            <a href="#">
                <ins>Edit</ins>
            </a>
            <a href="#">
                <ins>Download</ins>
            </a>
            <a href="#">
                <ins>view full size</ins>
            </a>


        </div>

    </div>
</div>


<div class="col-md-4 col-md-push-1">
    <div class="panel panel-default" style="border:2px solid black">
        <div class="panel-heading">
            <h3 class="panel-title" class="pull-left">Trending Topics</h3>
        </div>

        <div class="panel-body">

            <div class="row">
                <div class="col-md-2">
                    <img src="img.png" class="img img-thumbnail img-responsive" alt="Image" id="img2"
                         style="max-width:194%;height:100px;border:2px solid black">

                </div>

                <div class="col-md-8 col-md-push-1">

                    <span class="text-primary">Uday Pratap Singh</span>

                    <span class="text-primary pull-right">Grails</span><br>

                    <div>
                        <small>@uday</small>
                        <span>Subscribtions</span>
                        <span class="text-primary pull-right">post</span>
                    </div>

                    <div>
                        <a href='#' span class="text-primary pull-left">subscribtion</span></a>
                        <span>50</span>

                        <span class="text-primary pull-right">30</span>

                    </div>

                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                    <img src="img.png" class="img img-thumbnail img-responsive" alt="Image" id="img3"
                         style="max-width: 194%;height:100px;border:2px solid black">

                </div>

                <div class="col-md-8 col-md-push-1">

                    <span class="text-primary ">Uday Pratap Singh</span>

                    <span class="text-primary pull-right">Grails</span><br>

                    <div>
                        <small>@uday</small>
                        <span>Subscribtions</span>
                        <span class="text-primary pull-right">post</span>

                    </div>

                    <span class="pull-left dropdown">
                        <a class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown"
                           style="border:2px solid black">Serious
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                            <li><a href="#">JavaScript</a></li>
                        </ul>

                    </span>
                    <span class="text-center">50</span>
                    <span class="text-primary pull-right">30</span>

                    <div>
                        <span><a href='#' class="pull-right">Delete</a></span>
                        <span><a href='#'>Edit</a></span>
                        <span>
                            <a class="btn btn-default btn-sm dropdown-toggle pull-left" type="button"
                               data-toggle="dropdown" style="border:2px solid black">Public
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">HTML</a></li>
                                <li><a href="#">CSS</a></li>
                                <li><a href="#">JavaScript</a></li>
                            </ul>

                        </span>

                    </div>

                </div>

            </div>
        </div>

    </div>

</div>

</body>
</html>