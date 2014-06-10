/**
 * 
 **/
//$("#create-date-mail").slideup();
$(document).ready(function() {
	$("#choose-date-mail").click(function() {
		$("#create-date-mail").slideToggle("slow");
	});
});

$(function() {
    $( "#create-date-mail" ).dialog();
  });