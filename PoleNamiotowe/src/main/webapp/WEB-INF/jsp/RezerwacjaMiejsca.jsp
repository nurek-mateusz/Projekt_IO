<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="repositories.KawalekPola"%>
<%@page import="repositories.PoleRespository"%>
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
<body>
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
    <div class="container">

        <%
            repositories.PoleRespository poleRepository = new PoleRespository();
            List<KawalekPola> pola = poleRepository.pobierzKawalkiPola(
                    Integer.parseInt(request.getParameter("poleId")));
            for (KawalekPola x : pola) {
                out.println("<div class = \"poleNamiotowe\">");
                out.println("<info>");
                out.println("<id>");
                out.println(x.getId());
                out.println("</id>");
                out.println("<koszt>");
                out.println(x.getKoszt());
                out.println("</koszt>");

                out.println("<sizeX>");
                out.println(x.getWielkoscX());
                out.println("</sizeX>");

                out.println("<sizeY>");
                out.println(x.getWielkoscY());
                out.println("</sizeY>");

                out.println("<positionX>");
                out.println(x.getPozycjaX());
                out.println("</positionX>");

                out.println("<positionY>");
                out.println(x.getPozycjaY());
                out.println("</positionY>");

                out.println("</info>");
                out.println("</div>");
            }
        %>

    </div>

    <div class="informacjeOPolu">
        <h2>Koszt:</h2> 
        <koszt></koszt> zl/za noc
        <h2>Data rozpoczęcia:</h2> 
        <input id="dataRozpoczecia"type="date">rrrr-mm-dd<br>
        <h2>Data zakończenia:</h2> 
        <input id="dataZakonczenia"type="date">rrrr-mm-dd<br>
        <div class="standardowyPrzycisk">
            Chce to miejsce!
        </div>

    </div>
</body>