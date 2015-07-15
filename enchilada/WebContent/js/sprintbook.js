$(document)
		.ready(
				function() {

					$('#add-story-button')
							.click(
									function() {
										var storyName = $('#add-story-input')
												.val();
										$(
												'<li role="presentation" class="list-group-item tracked-story" data-story-id="'
														+ storyName
														+ '">'
														+ storyName
														+ '<span class="badge badge-story-filter"><span class="glyphicon glyphicon-filter"></span></span><span class="badge badge badge-story-tracker"><span class="glyphicon glyphicon-remove"/></span></li>')
												.hide()
												.insertBefore(
														$(
																"#tracked-stories li.list-group-item")
																.last())
												.slideDown();

										$('#add-story-input').val('');
									});
					$('.badge-feed')
							.click(
									function() {
										if ($(this).hasClass(
												'badge-feed-enabled')) {
											$(this).removeClass(
													'badge-feed-enabled');
											$(this).addClass(
													'badge-feed-disabled');
											$(this)
													.html(
															'<span class="glyphicon glyphicon-remove"></span>');

											console.log($(this).data('feed'));
											$("#stories").find(
													'.' + $(this).data('feed')
															+ '-story').each(
													function() {
														$(this).fadeOut();
													});

										} else {
											$(this).removeClass(
													'badge-feed-disabled');
											$(this).addClass(
													'badge-feed-enabled');
											$(this)
													.html(
															'<span class="glyphicon glyphicon-ok"></span>');
											$("#stories").find(
													'.' + $(this).data('feed')
															+ '-story').each(
													function() {
														$(this).fadeIn();
													});

										}
									});

					var data = [
							{
								"source" : "jira",
								"sourceLink" : "http: //jira.objective.com/browse/EWS-2047",
								"userStoryId" : "EWS-1737",
								"date" : "2015-07-15T13: 24: 33",
								"message" : "Justin Luciano spawned an issue",
								"name" : "Justin Luciano",
								"avatar" : "http: //link.to.avatar/justinluciano"
							},
							{
								"source" : "bamboo",
								"sourceLink" : "http: //bamboo.objective.com/browse/ECM831-EXEC-1076",
								"userStoryId" : "EWS-1676",
								"date" : "2015-07-15T11: 25: 41",
								"message" : "ECM8.3.x › Executive › #1076 was successful Changes by Fiona Morella",
								"name" : "Fiona Morella",
								"avatar" : "http: //link.to.avatar/fionamorella"
							},
							{
								"source" : "bamboo",
								"sourceLink" : "http: //bamboo.objective.com/browse/ECM831-EXEC-1082",
								"userStoryId" : "EWS-1895",
								"date" : "2015-07-15T23: 15: 21",
								"message" : "ECM8.3.x › Executive › #1072 failed Responsible: Justin Luciano",
								"name" : "Justin Luciano",
								"avatar" : "http: //link.to.avatar/justinluciano"
							},
							{
								"source" : "crucible",
								"sourceLink" : "http: //crucible.objective.com/cru/ECM83-435",
								"userStoryId" : "EWS-1238",
								"date" : "2015-07-14T08: 43: 11",
								"message" : "SriramAnanthram: Should not return action 'create-alias' for fA00. Do not fix this now as we need to check and ensure all folder types for which alias cannot be created Are handled.",
								"name" : "Eliel Goco",
								"avatar" : "http: //link.to.avatar/elielgoco"
							},
							{
								"source" : "svn",
								"sourceLink" : "",
								"userStoryId" : "EWS-1733",
								"date" : "2015-07-15T21: 30: 00",
								"message" : "EWS-1733 Updated resource, service, test",
								"name" : "Omar Bacani",
								"avatar" : "http: //link.to.avatar/omarbacani"
							} ];
					$
							.each(
									data,
									function(index, resp) {
										var srcLink = $("<div style='float: right; position: relative; top: 5px; clear: both;'><small><a><span class='story-source'>JIRA</span><span class='glyphicon glyphicon-link'></span></a></small></div>");
										srcLink.find("a").prop("href",
												resp.sourceLink);

										var item = $("<div></div>").addClass(
												"list-group-item").addClass(
												resp.source + "-story").prop(
												"data-story-id",
												resp.userStoryId);
										item.appendTo("#stories");

										srcLink.appendTo(item);
										
										$('<br clear="all">').appendTo(item);
										$('<div></div>')
											.addClass('media-left')
											.append('<a><img class="media-object" src="http://lorempixel.com/g/64/64/abstract" alt="..."></a>')
											.appendTo(item);
										$('<div></div>').addClass('media-body').append(resp.message).appendTo(item);
									});

				});

$(document.body).on("click", ".badge-story-tracker", function() {
	$(this).parents("li").slideUp();
});

$(document.body).on("click", ".badge-story-filter", function() {
	var p = $(this).parents("li");
	if (p.hasClass('focused-story')) {
		// unfocus this story
		p.removeClass('focused-story');
		$('#stories .list-group-item').each(function() {
			$(this).removeClass('hide-story').fadeIn();
		});
	} else {
		$('#tracked-stories').each(function() {
			$(this).removeClass('focused-story');
		});
		p.addClass('focused-story');

		var storyId = p.data('story-id');
		$('#stories .list-group-item').each(function() {
			if ($(this).data('story-id') != storyId) {
				$(this).addClass('hide-story').fadeOut();
			}
		});
	}
});