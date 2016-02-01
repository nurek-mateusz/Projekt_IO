/* global $infoOPolu */

$.urlParam = function(name){
	var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	return results[1] || 0;
}

$(document).ready(function () {
    var aktywny = null;
    var infoOPolu = $(document).find(".infoOPolu");
    $(".draggable").click(function () {
        if (aktywny)
        {
            aktywny.css("background-color", "#37F");
        }
        aktywny = $(this);
        aktywny.css("background-color", "#F33");
        infoOPolu.css("display", "inline");
        var val = $(".infoOPolu #kwota").val(aktywny.find("info kwota").text());
    });

    $("#save").click(function () {
        var ilosc = 0;
        var tekst = "";
        $(".draggable").each(function (index , value) {
            ilosc++;
            var position = $(value).position();
            var height = $(value).height();
            var width = $(value).width();
            var koszt = $(value).find("info kwota").text();
            tekst += position.left.toString() + ',' + position.top.toString() + 
                    ',' + height.toString() + ',' + width.toString()+',' + koszt+',';
           
        });
        tekst=tekst.substr(0,tekst.length-1);
        tekst = '{' +tekst+'}';
        $.get("/PoleNamiotowe/edycjaPola", { dane:tekst, poleId: $.urlParam('poleId').toString()  });
    });

    $(".infoOPolu zamkniecie").click(function () {
        aktywny.css("background-color", "#37F");
        infoOPolu.css("display", "none");
    });

    $(".infoOPolu #zapisz").click(function () {
        var val = $(".infoOPolu #kwota").val();
        aktywny.find("info kwota").text(val);
    });


    $("#przyciskDodania").click(function () {
        var divs = $(document).find(".container").append("<div  class=\"draggable\">" +
                "<info>" +
                "<kwota>" +
                "100" +
                "</kwota>" +
                "</info>" +
                "</div>");
        $(function () {
            var x = 0;
            $(".draggable").each(function () {
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

        $(".draggable").click(function () {
            if (aktywny)
            {
                aktywny.css("background-color", "#37F");
            }
            aktywny = $(this);
            aktywny.css("background-color", "#F33");
            infoOPolu.css("display", "inline");
            var val = $(".infoOPolu #kwota").val(aktywny.find("info kwota").text());
        });

    });
});

