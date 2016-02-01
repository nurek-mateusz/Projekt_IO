<%@page import="Domain.PoleNamiotowe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="repositories.PoleRespository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/bootstrap.css" />
<link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/stronaGlownaStyle.css" />
<link rel="Stylesheet" type="text/css" href="/PoleNamiotowe/css/stylPol.css" />
<script src="/PoleNamiotowe/js/jquery-2.2.0.min.js"></script>
<script src="/PoleNamiotowe/js/bootstrap.min.js"></script>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="/PoleNamiotowe/js/skrypt.js"></script>
<script src="/PoleNamiotowe/js/skryptLista.js"></script>
<style>
    .elementListy
    {
        width: 90%;

        left: 5%;
        position: relative;
        background-color: white;
        border: 1px solid #000;
        margin: 3px;

        padding: 5px;
    }
    .elementListy:hover
    {
        background-color: #ddd;
    }
    .elementListy .id{
        width:10%;
        float:left;
        border-right: 1px solid #aaa;
        position: relative;
    }

    .elementListy .nazwa{
        position: relative;
        float:left;
        padding: 3px;
        width:20%;
        border-right: 1px solid #aaa;
    }
    .elementListy .miejscowosc{
        position: relative;

        padding: 3px;
        border-right: 1px solid #aaa;
    }

    .elementListy .miejscowosc{
        position: relative;
        float: left;
        padding: 3px;
        width:40%;

    }
    .elementListy .rozwin{


        padding: 3px;
        width:30%;
    }
    .elementListy .zwin{

        display: none;
        padding: 3px;
        width:30%;
    }

    .elementListy .dodatkoweInfo
    {
        position: relative;
        display:none;
        width: 100%;


    }

    .naglowekListy
    {
        width: 90%;

        left: 5%;
        position: relative;
        background-color: white;

        margin: 3px;

        padding: 5px;
    }

    .naglowekListy .id{
        width:10%;
        float:left;

        position: relative;
    }

    .naglowekListy .nazwa{
        position: relative;
        
        padding: 3px;
        width:20%;

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


<div class="col-sm-6">
    <div class = "lista">

        <div class = "naglowekListy">
            <div class = "id">
                Id
            </div>
            <div class = "nazwa">
                Adres
            </div>

        </div>


                <%
                    repositories.PoleRespository poleRepository = new PoleRespository();
                    ArrayList<PoleNamiotowe> pola = poleRepository.getWszystkiePola();

                    String userIdStr = (String) session.getAttribute("userId");
                    int userId = Integer.parseInt(userIdStr);

                    ArrayList<PoleNamiotowe> polaUzytkownika = new ArrayList<PoleNamiotowe>();

                    for (int i = 0; i < pola.size(); ++i) {
                        if (pola.get(i).getUserId() == userId) {
                            polaUzytkownika.add(pola.get(i));
                        }
                    }

                    for (PoleNamiotowe x : polaUzytkownika) {
                        out.println("<div class = \"elementListy\">");
                        out.println("<div class = \"id\">");
                        out.println(x.getId());
                        out.println("</div>");

                        out.println("<div class = \"miejscowosc\">");
                        out.println(x.getAdres());
                        out.println("</div>");

                        out.println("<span class = \"rozwin\">");
                        out.println("Dowiedz się więcej!");
                        out.println("</span>");

                        out.println("<span class = \"zwin\">");
                        out.println("Zwiń!");
                        out.println("</span>");

                        out.println("<div class = \"dodatkoweInfo\">");
                        out.println("<opis>");
                        out.println("</br>");
                        out.println(x.getOpis());
                        out.println("</opis>");
                        out.println("<a href=\"/PoleNamiotowe/edycjaPola?poleId=" + x.getId() + "\">Edytuj to pole</a>");
                        out.println("</div>");
                        out.println("</div>");

                    }
                %>
            </div> 
        </div>

    </div>
</div>
<div class="col-sm-6">
    <h1>
        Chcesz dodać nowe pole? 
    </h1>
    <a href ="/PoleNamiotowe/DodawaniePola">
        <div class="col-sm-6">
            <div class="niebieskiStandardowyPrzycisk" id = "czerwony">
                Dodaj nowe pole
            </div>
        </div>
    </a>
</div>
