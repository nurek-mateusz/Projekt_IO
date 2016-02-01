<meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
<link rel="Stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="Stylesheet" type="text/css" href="css/stronaGlownaStyle.css" />
<link rel="Stylesheet" type="text/css" href="css/stylPol.css" />
<script src="js/jquery-2.2.0.min.js"></script>
<script src="js/bootstrap\js\bootstrap.min.js"></script>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="js/skrypt.js"></script>



<div class="header">

    <div class="row">
        <div class="col-sm-6">
            <a href="/PoleNamiotowe/lista/"> <h1>
                    <div class="tekstNaglowka">
                        Pole namiotowe
                    </div>
                </h1></a>
        </div>
        <div class="col-sm-3">
            <div class="standardowyPrzycisk">
                Kontakt
            </div>
        </div>

    </div>

</div>

<div class="container">
    <div  class="draggable" id="draggableNotHere"> 
        <info>
            <kwota>500</kwota>
        </info>
    </div>
    <div  class="draggable" id="draggableNotHere">
        <info>
            <kwota>50</kwota>
        </info>
    </div>
    <div  class="draggable" id="draggableNotHere">
        <info>
            <kwota>100</kwota>
        </info>
    </div>
</div>


<button id ="przyciskDodania" type="button" class="btn btn-lg btn-primary" style="position: absolute; bottom: 10px;" >Dodaj</button>
<button id ="save" type="button" class="btn btn-lg btn-primary" style="position: absolute; bottom: 10px; left: 10%;" >Zapisz</button>

<div class = "infoOPolu">
    <zamkniecie>X</zamkniecie>
    <br/>
    <label>Kwota za noc:</label>
    <input type=text id="kwota" onkeyup="this.value = this.value.replace(/\D/g, '')" />


    <button type="button" id="zapisz" class="btn btn-lg btn-primary" >Zapisz</button>

</div>

<script src="js/szczegoloweInfo.js"></script>


