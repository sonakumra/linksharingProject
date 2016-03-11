%{--<div class="">--}%
    <div class="panel-heading" data-topic-id="${topicList.id}">
        Subscriptions
        <div class="pull-right">
            <a href="#" class="text-primary">View All</a>
        </div>
    </div>

    <div class="panel-body" data-topic-id="${topicList.id}">
        <div class="row">
            <div class="col-md-3">
                <img src="male-silhouette.jpg" class="img-thumbnail img-responsive" alt="Image"
                     id="uimg" style="width:75px;height:75px">
            </div>

            <div class="col-md-9">
                <div class="row">
                    <div class="col-md-6 col-xs-6">
                        <span class="text-primary">${session.user.username}</span>
                    </div>

                    <div class="col-md-4 col-md-offset-2  col-xs-6">
                        <span class="text-primary"><ins>${topicList.name}</ins></span>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <span class="text-muted">@${session.user.firstName}</span><br/>
                        %{--<a href="#">--}%
                        %{--<ins>Unsubscribe</ins>--}%
                        %{--</a>--}%
                        <ls:showSubscribe topicID="${topicList.id}"/>
                    </div>

                    <div class="col-md-4 col-xs-6">
                        <span class="text-muted">Subscriptions</span><br/>
                        <ls:subscriptionCount topicId="${topicList.id}"/>
                    </div>

                    <div class="col-md-4 col-xs-6">
                        <span class="text-muted">Topics</span><br/>
                        <ls:topicCount userId="${session.user.id}"/>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="panel-footer" data-topic-id="${topicList.id}">
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
    </div>
%{--</div>--}%
%{--<div class="panel-body">--}%
%{--<div class="row">--}%
%{--<div class="col-md-3">--}%
%{--<img src="male-silhouette.jpg" class="img-thumbnail img-responsive" alt="Image"--}%
%{--id="uimg" style="width:75px;height:75px">--}%
%{--</div>--}%
%{--<div class="col-md-9">--}%
%{--<div class="row">--}%
%{--<div class="col-md-6 col-xs-6">--}%
%{--<span class="text-primary">sona kumra</span>--}%
%{--</div>--}%
%{--<div class="col-md-4 col-md-offset-2  col-xs-6">--}%
%{--<span class="text-primary"><ins>Grails</ins></span>--}%
%{--</div>--}%
%{--</div>--}%
%{--<div class="row">--}%
%{--<div class="col-md-4">--}%
%{--<span class="text-muted">@sona</span><br/>--}%
%{--<a href="#">--}%
%{--<ins>Unsubscribe</ins>--}%
%{--</a>--}%
%{--</div>--}%
%{--<div class="col-md-4 col-xs-6">--}%
%{--<span class="text-muted">Subscriptions</span><br/>--}%
%{--<span class="text-primary">50</span>--}%
%{--</div>--}%
%{--<div class="col-md-4 col-xs-6">--}%
%{--<span class="text-muted">Topics</span><br/>--}%
%{--<span class="text-primary">30</span>--}%
%{--</div>--}%
%{--</div>--}%
%{--</div>--}%
%{--</div>--}%
%{--</div>--}%
%{--<div class="panel-footer">--}%
%{--<div class="row">--}%
%{--<div class="col-md-4 col-md-push-4">--}%
%{--<div class="dropdown">--}%
%{--<button class="btn btn-default dropdown-toggle" type="button"--}%
%{--data-toggle="dropdown">Serious--}%
%{--<span class="caret"></span></button>--}%
%{--<ul class="dropdown-menu">--}%
%{--<li><a href="#">....</a></li>--}%
%{--<li><a href="#">....</a></li>--}%
%{--</ul>--}%
%{--</div>--}%
%{--</div>--}%
%{--<div class="col-md-8 col-md-push-4">--}%
%{--<a href="#"><span class="glyphicon glyphicon-envelope"--}%
%{--style="font-size:20px"></span></a>--}%

%{--</div>--}%
%{--</div>--}%
%{--</div>--}%