<meta http-equiv="Content-Type" content="text/html;charset=utf-8" >
<link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/bootstrap.css" />
<link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/stronaGlownaStyle.css" />
<link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/stylPol.css" />
<script src="/PoleNamiotowe/js/jquery-2.2.0.min.js"></script>
<script src="bootstrap\js\bootstrap.min.js"></script>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="/PoleNamiotowe/js/RezerwacjaMiejsca.js"></script>



<style>
    .container
    {
        position: relative;
        margin: 10px;
        width: 60%;
        float: left;
        overflow:scroll; 
    }
    .poleNamiotowe
    {
        border: 1px solid black;
        position: absolute;
    }
    .poleNamiotowe info {
        display: none;
    }
    .informacjeOPolu
    {
        display: none;
        float: left;
    }
    .informacjeOPolu .standardowyPrzycisk
    {
        margin: 30px;
    }
</style>
<div class="header">
    <div class="row">
        <div class="col-sm-6">
            <a href="/PoleNamiotowe/"> <h1>
                    <div class="tekstNaglowka">
                        Pole namiotowe
                    </div>
                </h1></a>
        </div>
        <div class="col-sm-3">
            <a href="/PoleNamiotowe/kontakt"><div class="standardowyPrzycisk">
                    Kontakt
                </div></a>
        </div>
    </div>
</div>
<h2>Pole namiotowe Dupa2</h2>
<div class="container">
    <div  class="poleNamiotowe"> 
        <info>
            <id>
                4
            </id>
            <koszt>
                100.00
            </koszt>
            <sizeX>
                50
            </sizeX>
            <sizeY>
                50
            </sizeY>
            <positionX>
                200
            </positionX>
            <positionY>
                50
            </positionY>
            <rodzajParceli>
                Zwykla
            </rodzajParceli>
        </info>
    </div>

    <div  class="poleNamiotowe"> 
        <info>
            <id>
                3
            </id>
            <koszt>
                500.00
            </koszt>
            <sizeX>
                300
            </sizeX>
            <sizeY>
                300
            </sizeY>
            <positionX>
                200
            </positionX>
            <positionY>
                200
            </positionY>
            <rodzajParceli>
                Zwykla
            </rodzajParceli>
        </info>
    </div>

    <div  class="poleNamiotowe"> 
        <info>
            <id>
                2
            </id>
            <koszt>
                200.00
            </koszt>
            <sizeX>
                100
            </sizeX>
            <sizeY>
                300
            </sizeY>
            <positionX>
                1000
            </positionX>
            <positionY>
                0
            </positionY>
            <rodzajParceli>
                Zwykla
            </rodzajParceli>
        </info>
    </div>
</div>

<div class="informacjeOPolu">
    <h2>Koszt:</h2> 
    <koszt></koszt> zl/za noc
    <div class="standardowyPrzycisk">
        Chce to miejsce!
    </div>

</div>
