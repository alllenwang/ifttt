$(".message-sender").next().hide();

$(".message-sender").click(function() {
	$(this).next().slideToggle("slow");
});


