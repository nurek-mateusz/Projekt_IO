<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="Stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="Stylesheet" type="text/css" href="css/stronaGlownaStyle.css" />
<link rel="Stylesheet" type="text/css" href="css/stylPol.css" />
<script src="js/jquery-2.2.0.min.js"></script>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="js/RezerwacjaMiejsca.js"></script>

<style>
    .zawartosc{
        margin:30px;
    }
</style>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" >
    </head>
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
                <div class="standardowyPrzycisk">
                    Kontakt
                </div>
            </div>
        </div>
    </div>
    <div class="zawartosc">
        <h2>Zarejestruj si?</h2>
        <h4>Masz już konto? Zaloguj się <a>tutaj</a></h4>
        <div class="col-sm-4">
            <form action="/PoleNamiotowe/rejestracja">
<!--                <label for="pwd">Login:</label>-->
                <input type="text" class="form-control" name="usr">
<!--                <label for="pwd">Hasło:</label>-->
                <input type="password" class="form-control" name="pwd">
<!--                </br>
                <label><input type="checkbox"> Zapoznałem się z <a data-toggle="modal" data-target="#myModal">regulaminiem</a></label>-->
                <button type="submit" class="btn btn-default">Zarejestruj się!</button>
            </form>
        </div>
    </div>

    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Regulamin pola namiotowego</h4>
                </div>
                <div class="modal-body">
                    <p>1. Warunkiem korzystania z tej strony jest pełne zrozumienie, zaakceptowanie i przestrzeganie reguł serwisu.</p> 
                    <p>2. Wchodząc na stronę automatycznie zgadzasz się, aby Twój adres IP był do wględu administracji.</p>  
                    <p>3. Nie floodujemy, nie spamujemy.</p>
                    <p>4. Obowiązuje zakaz używania emotikonek (również w cytatach). Wyjątek stanowią: :3 ;3 ;_; xD oraz spurdoemotki. Nie pytaj, dlaczego te, a nie inne - tak działa życie.</p>
                    <p>5. Serwis jest niewskazany dla osób chorujących na epilepsję.</p>     
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
</html>