
<div class="modal fade" id="sendinviteModal" tabindex="-1" role="dialog" aria-labelledby="sendinviteModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="sendinviteModalLabel">Send Invitation</h4>
            </div>
            <g:form class="form-horizontal" name="email">
                <div class="modal-body table-responsive">
                    <table class="table table-condensed">
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
                                    <label for="topic">Topic *</label>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <g:select name="topic" from="" class="btn dropdown-toggle" data-toggle="dropdown"/>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <g:submitButton name="submitbutton" type="submit" class="btn btn-primary">Invite</g:submitButton>
                                </div>
                            </td>
                            <td>
                                <div class="form-group">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </g:form>
        </div>
    </div>
</div>