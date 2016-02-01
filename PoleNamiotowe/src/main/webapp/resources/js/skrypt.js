$(function() {
  var x = 0;
$(".draggable").each(function() {
        x++;
        $(this).draggable({
            containment: $('.container'),
            scroll: true
        });
        $(this).resizable({
            containment: $('.container')
        });

    });
 
});
