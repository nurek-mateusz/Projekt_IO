<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    //            // check if user has a valid session
    //            if (session.getAttribute("userId") == null) {
    //                response.sendRedirect("/PoleNamiotowe/");
    //            }

%>
<html>
    <head>
        <title>Dodawanie pola</title>
        <link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/bootstrap.css" />
        <link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/stronaGlownaStyle.css" />
    </head>
    <div class="header">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <a href="/PoleNamiotowe/lista/"> <h1>
                            <div class="tekstNaglowka">
                                Pole namiotowe
                            </div>
                        </h1></a>
                </div>
                <div class="col-sm-3">
                    <a href="/PoleNamiotowe/kontakt">
                        <div class="standardowyPrzycisk">Kontakt</div>
                    </a>
                </div>

            </div></div>
    </div>

    <div class="zawartosc">
        <h2>Witaj w panelu dodawanie nowego pola namiotowego! </h2>
        <h3>Ta strona skierowana jest tylko dla właścicieli pól namiotowych</h3>
        Aby utworzyć pole musisz wpisać adres tego pola:
        <br/>
        <br/>
        <div class="col-sm-3">




            <form action="/PoleNamiotowe/dodawaniePola">
                <label for="adres">Adres:</label>
                <input type="text" class="form-control" name="adres">

                <label for="pwd">Opis</label>
                <input type="text" class="form-control" name="opis">

                </br>
                <button type="submit" class="btn btn-default">Dodaj pole</button>
            </form>
        </div>


    </div>

</html>
