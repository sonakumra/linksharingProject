<%--
  Created by IntelliJ IDEA.
  User: sona
  Date: 26/2/16
  Time: 3:45 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="application">
    <asset:javascript src="app.js"/>
    <title></title>
</head>

<body>
<div class="row">
    <div class="col-md-4">
        <div class="row">
            <div class="panel panel-default panel-primary">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3">
                            <ls:userImage id="${session.user.id}"/>
                        </div>

                        <div class="col-md-9">
                            <span class="text-primary">sona kumra</span><br/>
                            <span class="text-muted">@sona</span>

                            <div class="row">
                                <div class="col-md-4 col-xs-6">
                                    <span class="text-muted">Subscriptions</span><br/>
                                    <span class="text-primary">50</span>
                                </div>

                                <div class="col-md-4 col-md-offset-2 col-xs-6">
                                    <span class="text-muted">Topics</span><br/>
                                    <span class="text-primary">30</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default panel-primary">
                <g:each in="${topicList}" var="topic">
                    <g:render template="subscribers" model="[topicList: topic]"/>
                </g:each>

            </div>
        </div>

        <div class="row">
            <div class="panel panel-default panel-primary">
                <div class="panel-heading">
                    Trending Topics
                </div>
                <g:each in="${topicVOList}" var="tlist">
                    <div class="panel-body">

                        <g:render template="trendingTopics" model="[topic: tlist]"/>

                    </div>

                    <div class="panel-footer">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            data-toggle="dropdown">Serious
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">....</a></li>
                                        <li><a href="#">....</a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-md-4">
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            data-toggle="dropdown">Private
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">....</a></li>
                                        <li><a href="#">....</a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="col-md-4">
                                <a href="#"><span class="glyphicon glyphicon-envelope"
                                                  style="font-size:20px"></span></a>
                                <a href="#"><span class="fa fa-file-o" style="font-size:20px"></span></a>
                                <a href="#"><span class="fa fa-trash" style="font-size:20px"></span></a>
                            </div>
                        </div>
                    </div></g:each>
            </div>
        </div>
    </div>

    <div class="col-md-7 col-md-push-1">
        <div class="row">
            <div class="row">
                <div class="panel panel-default panel-primary">
                    <div class="panel-heading">
                        Inbox
                    </div>

                    <div class="panel-body">
                        <g:each in="${readingItems}" var="readingItem">
                            <div class="row">
                                <div class="col-md-2">
                                    %{--<img src="#" class="img img-thumbnail img-responsive" alt="Image" id="uimg"--}%
                                         %{--style="width:75px;height:75px">--}%

                                </div>

                                <div class="col-md-10">
                                    <div class="row">
                                        <div class="col-md-3">
                                            <span class="text-primary">sona</span>
                                        </div>

                                        <div class="col-md-2">
                                            <span class="text-muted">@sona</span>
                                        </div>

                                        <div class="col-md-2">
                                            <span class="text-muted">5 min</span>
                                        </div>

                                        <div class="col-md-2 col-md-offset-3">
                                            <span class="text-primary pull-right">Grails</span>
                                        </div>
                                    </div>

                                    <div class="panel text-justify">
                                        <p>${readingItem[4]}</p>
                                    </div>

                                    <div class="panel-footer">
                                        <a href="#"><span class="fa fa-facebook-square" style="font-size:20px"></span>
                                        </a>
                                        <a href="#"><span class="fa fa-tumblr" style="font-size:20px"></span></a>
                                        <a href="#"><span class="fa fa-google-plus" style="font-size:20px"></span></a>
                                        %{--<a href="#" class="pull-right">Download</a>--}%
                                        %{--<a href="#" class="pull-right">View Full Site</a>--}%
                                        <a href="#" style="margin-left: 180px">

                                            <ls:checkType id="${readingItem[0]}" url="${readingItem[2]}"
                                                          filePath="${readingItem[3]}"/>



                                            <ls:markRead isRead="${readingItem[1]}" id="${readingItem[0]}"/>
                                            <g:link controller="user" action="viewPost" params="[id:readingItem[0]]">View Post</g:link>
                                    </div>
                                </div>
                            </div>
                        </g:each>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

%{--<div class="container">

    <div class="modal fade" id="sendinviteModal" tabindex="-1" role="dialog" aria-labelledby="sendinviteModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="sendinviteModalLabel">Send Invitation</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group row">
                            <label for="email" class="col-sm-4 form-control-label">Email *</label>

                            <div class="col-sm-8">
                                <input type="email" class="form-control" id="email">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="topic" class="col-sm-4 form-control-label">Topic *</label>

                            <div class="col-sm-8">
                                <div class="dropdown">
                                    <button class="btn dropdown-toggle" id="topic" type="button" data-toggle="dropdown">
                                        <span class="glyphicon glyphicon-user"></span>Public
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">.....</a></li>
                                        <li><a href="#">.....</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-4 form-control-label">
                                <button type="button" class="btn btn-default btn-block"
                                        data-dismiss="modal">Close</button>
                            </div>

                            <div class="col-sm-8">
                                <button type="button" class="btn btn-primary btn-block">invite</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="sharedocModal" tabindex="-1" role="dialog" aria-labelledby="sharedocModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="sharedocModalLabel">Share Document</h4>
                </div>

                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group row">
                            <label for="doc" class="col-sm-4 form-control-label">Document *</label>

                            <div class="col-sm-8">
                                <input type="file" id="doc" name="doc" required>
                            </div>
                        </div>

                        <div class="form-horizontal row">
                            <label for="description" class="col-sm-4 form-control-label">Description *</label>

                            <div class="col-sm-8">
                                <textarea id="description"></textarea>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="docTopic" class="col-sm-4 form-control-label">Topic *</label>

                            <div class="col-sm-8">
                                <div class="dropdown">
                                    <button class="btn dropdown-toggle" id="docTopic" type="button"
                                            data-toggle="dropdown">
                                        <span class="glyphicon glyphicon-user"></span>Public
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">.....</a></li>
                                        <li><a href="#">.....</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-sm-4 form-control-label">
                                <button type="button" class="btn btn-default btn-block"
                                        data-dismiss="modal">Close</button>
                            </div>

                            <div class="col-sm-8">
                                <button type="button" class="btn btn-primary btn-block">Share</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>--}%
</body>
</html>
