
<div class="modal fade" id="sharelinkModal" tabindex="-1" role="dialog" aria-labelledby="sharelinkModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="sharelinkModalLabel">Share Link</h4>
            </div>
            <g:form class="form" controller="resource" action="saveLinkResource">
                <div class="modal-body table-responsive">
                    <table class="table table-condensed">
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="link">Link *</label>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <g:field type="url" id="link" name="url"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="description">Description *</label>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <g:textArea name="description" id="description"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="topicName">Topic *</label>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <div class="dropdown">
                                        <g:select name="topicName" from="${subscriptionTopic}" class="btn dropdown-toggle" data-toggle="dropdown"/>

                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <g:submitButton name="submit" value="share" type="submit" class="btn btn-primary"/>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </g:form>
        </div>
    </div>
</div>
