// $('.dataView').hide();
// var $currentContent = $('#events');

// $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function());

function showContent(selector) {
	if (selector != '#' + $currentContent[0].id) {
		$currentContent.slideToggle();
		// $currentContent.hide();
		$(selector).slideToggle();
		$currentContent = $(selector);
	}
}

$('.nav').on('click', '.nav-link', function(e) {
	$('.nav-link').removeClass('active');
	$(e.currentTarget).addClass('active');
  showContent(e.currentTarget.hash);
  e.preventDefault();
}); 

// show '#events' content on page load
// showContent('#events');
// $currentContent.hide();
// $currentContent.fadeIn('slow');