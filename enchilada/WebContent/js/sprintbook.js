$( document ).ready(function() {
	
 
	
	$('#add-story-button').click(function(){
		var storyName = $('#add-story-input').val();
		$('<li role="presentation" class="list-group-item" data-story-id="'+storyName+'"><a href="#">'+storyName+' </a><span class="badge badge badge-story-tracker"><span class="glyphicon glyphicon-remove"/></span></li>').hide().insertBefore($("#tracked-stories li.list-group-item").last()).slideDown();
		
		$('#add-story-input').val('');
	});
	$('.badge-feed').click(function(){
		if($(this).hasClass('badge-feed-enabled')){
			$(this).removeClass('badge-feed-enabled');
			$(this).addClass('badge-feed-disabled');
			$(this).html('<span class="glyphicon glyphicon-remove"></span>');
			
			console.log($(this).data('feed'));
			$("#stories").find('.'+$(this).data('feed')+'-story').each(function(){
				$(this).fadeOut();
			});
			
		}else{
			$(this).removeClass('badge-feed-disabled');
			$(this).addClass('badge-feed-enabled');
			$(this).html('<span class="glyphicon glyphicon-ok"></span>');
			$("#stories").find('.'+$(this).data('feed')+'-story').each(function(){
				$(this).fadeIn();
			});
			


		}
	});

});

$(document.body).on("click", ".badge-story-tracker", function(){
  $(this).parents("li").slideUp();
})