$( document ).ready(function() {
var container = $( document ).find(".container");
var containerPosition = container.offset();
var polaNamiotowe = $( document ).find(".container .poleNamiotowe");
polaNamiotowe.css("background-color", "#4169E1");
var informacjeOPolu = $( document ).find(".informacjeOPolu");
var aktywne = null;

polaNamiotowe.each(function(i, value) {
  var poxitionX = parseInt($(value).find("info positionX").text());
  var poxitionY = parseInt($(value).find("info positionY").text());
  
  var sizeX = parseInt($(value).find("info sizeX").text());
  var sizeY = parseInt($(value).find("info sizeY").text());

  $(value).css("left", poxitionX);
  $(value).css("top", poxitionY);
  
  $(value).css("width", sizeX);
  $(value).css("height", sizeY);
});

polaNamiotowe.click(function(){
	aktywne = $( this );
	informacjeOPolu.css("display", "inline");
	informacjeOPolu.find("koszt").text( aktywne.find("info koszt").text() );
	polaNamiotowe.css("background-color", "#4169E1");
	$( this ).css("background-color", "#C12121");
});

});