<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
    <head>
        <title>Strona glowna</title>
        <link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/bootstrap.css" />
        <link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/stronaGlownaStyle.css" />
    </head>
    <div class="header">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <a href="/PoleNamiotowe/"> <h1>
                            <div class="tekstNaglowka">
                                Pole namiotowe
                            </div>
                        </h1></a>
                </div>
                
                <div class="col-sm-6">
                    <a href="/PoleNamiotowe/rejestracja">
                        <div class="standardowyPrzycisk">Zarejestruj się</div>
                    </a>
                </div>

            </div></div>
    </div>

    <div class="wierszLogowania" style="background-image: url('/PoleNamiotowe/img/namiot (2).jpg')">

        <div class="col-sm-6"></div>
        <div class="col-sm-6">
            <div class="poleLogowania">
                 <form action="/PoleNamiotowe/login">
                <h3>Zaloguj się:</h3>
                 <%
                         if(request.getAttribute( "blad" ) != null)
                        {
                             out.print("<div class=\"alert alert-danger\"><Strong>BLĄD!</strong>");
                             out.print(request.getAttribute( "blad" ));
                             out.print("</div>");
                        }
                   %>
                <h4>Login:</h4>
                <input class="form-control" type="text" name="usr">
                <h4>Hasło:</h4>
                <input class="form-control" type="password" name="pwd">
                <br/>
                <button type="submit" class="btn btn-default">Zaloguj się</button>
                 </form>
            </div>
        </div>

    </div>

    <div class="kimJestesmy">
        <h1>Informacje o nas:</h1>
        <h4>Od ponad 7 lat zajmujemy się zarządzania polem namiotowym i
            jesteśmy ekspertami w tej dziedzinie.</h4>
        Dołoncz do 9000 zadowolonych klientów.
    </div>

</html>
