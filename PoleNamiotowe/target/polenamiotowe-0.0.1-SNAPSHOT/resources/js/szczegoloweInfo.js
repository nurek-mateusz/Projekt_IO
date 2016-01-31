$( document ).ready(function() {
    $( ".draggable" ).click(function() {
		var divs = $( this ).find("nazwa").text();
		console.log(divs);
		var divs = $( document ).find(".infoOPolu").find(".nazwaPola").text(divs);
		$( document ).find(".infoOPolu").css( "display", "inline" );
    });
	
	$( ".infoOPolu zamkniecie" ).click(function() {
		$( document ).find(".infoOPolu").css( "display", "none" );
	});
	
	
	$( "#przyciskDodania" ).click(function() {
		var divs = $( document ).find(".container").append( "<div  class=\"draggable\">"+ 
		"<info>"+
			"<nazwa>"+
				"przykladowa nazwa"+
			"</nazwa>"+
		"</info>"+
	"</div>" );
					$(function() {
						$( ".draggable" ).draggable({
						obstacle: "#butNotHere",
						preventCollision: true,
						containment: ".container"
					}).resizable();
});

    });
});

