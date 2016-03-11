// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

function ajaxSuccess(result) {

	if (result) {
		var jsonResponseDiv = $(".jsonResponse");

		if (result.message) {



			jsonResponseDiv.text(result.message);
			jsonResponseDiv.addClass("alert alert-success");
		}
		else {
			jsonResponseDiv.text(result.error);
			jsonResponseDiv.addClass("alert alert-danger");
		}
		jsonResponseDiv.css({'display': 'block'})
	}
}

function hideSubscription(response) {
    ajaxSuccess(response)
    var topicId = response.id;
    $(".panel-heading[data-topic-id='"+topicId+"']").hide('slow')
    $(".panel-body[data-topic-id='"+topicId+"']").hide('slow')
    $(".panel-footer[data-topic-id='"+topicId+"']").hide('slow')
}

	$(document).ready(function () {

        console.log("ajax bind", $(".unsubscribe"));

		$(".unsubscribe").click(function (e) {
            console.log("after" +$(e.target).data('id'))
			$.ajax({
				url: "/subscription/delete",
				data: {id: $(e.target).data('id')},
				success: hideSubscription
			});
		});
});


