<div class="modal fade" id="sharedocModal" tabindex="-1" role="dialog" aria-labelledby="sharedocModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="sharedocModalLabel">Share Document</h4>
            </div>
            <g:form class="form">
                <div class="modal-body table-responsive">
                    <table class="table table-condensed">
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="doc">Document *</label>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <g:uploadForm>
                                        <input type="file" id="doc" name="doc" required>
                                    </g:uploadForm>
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
                                    <g:textArea  name="description" id="description"></g:textArea>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="topiclist">Topic *</label>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <div class="dropdown">
                                        <g:select name="topiclist" from="" class="btn dropdown-toggle" data-toggle="dropdown"/>

                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <g:submitButton name="submitbutton" type="button" class="btn btn-primary">Share</g:submitButton>
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
