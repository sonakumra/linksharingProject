<div class="modal fade" id="sharedocModal" tabindex="-1" role="dialog" aria-labelledby="sharedocModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="sharedocModalLabel">Share Document</h4>
            </div>
            <g:uploadForm class="form" controller="documentResource" action="save">
                <div class="modal-body table-responsive">
                    <table class="table table-condensed">
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="file">Document</label>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <input type="file" id="file" name="file" required>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="description">Description</label>
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
                                    <label for="topic">Topic</label>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <div class="dropdown">
                                        <g:select name="topic" from="${subscriptionTopic}" optionKey="id"
                                                  class="btn dropdown-toggle" data-toggle="dropdown"/>

                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <g:submitButton name="submit" type="submit"
                                                    class="btn btn-primary">Save</g:submitButton>
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
            </g:uploadForm>
        </div>
    </div>
</div>
