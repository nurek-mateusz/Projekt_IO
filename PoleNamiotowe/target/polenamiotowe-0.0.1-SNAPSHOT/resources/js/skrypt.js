$(function() {
     $( ".draggable" ).draggable({
    obstacle: "#butNotHere",
    preventCollision: true,
    containment: ".container"
}).resizable();
});


$("#dragMe").draggable({
    obstacle: "#butNotHere",
    preventCollision: true,
    containment: "#moveInHere"
}).resizable();;
