$( document ).ready(function() {

 $( ".elementListy .rozwin" ).click(function() {

 $( this ).parent().find(".dodatkoweInfo").show( "slow" );
	 $( this ).parent().find(".zwin").css( "display", "inline" );
	 $( this ).css( "display", "none" );
	 });

 $( ".elementListy .zwin" ).click(function() {
	 $( this ).parent().find(".dodatkoweInfo").slideUp();
	 $( this ).parent().find(".rozwin").css( "display", "inline" );
	 $( this ).css( "display", "none" );
	 });


});

