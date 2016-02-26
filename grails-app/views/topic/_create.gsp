<div class="container">
            <div class="modal fade" id="createtopicModal" tabindex="-1" role="dialog" aria-labelledby="createtopicModal">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="createtopicModalLabel">Create Topic</h4>
                        </div>
                        <g:form class="form" controller="topic" action="save">
                            <div class="modal-body table-responsive">
                                <table class="table table-condensed">
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <label for="topicName">Name *</label>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <g:textField id="topicName" name="topicName"/>
                                            </div>
                                        </td>
                                    </tr>
                                     <tr>
                                        <td>
                                            <div class="form-group">
                                                <label for="visibility">Visibility *</label>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <div class="dropdown">
                                                    %{--submit type submit--}%
                                                    <g:select name="visibility" from="${com.ttnd.linksharing.Visibility.values()}" class="btn dropdown-toggle" data-toggle="dropdown"/>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <g:submitButton name="submitbutton" type="submit" value="Save" class="btn btn-primary"/>
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
        </div>