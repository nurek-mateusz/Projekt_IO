<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="Stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="Stylesheet" type="text/css" href="css/stronaGlownaStyle.css" />
<link rel="Stylesheet" type="text/css" href="css/stylPol.css" />
<script src="js/jquery-2.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="js/skrypt.js"></script>
<script src="js/skryptLista.js"></script>
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
float:left;
padding: 3px;
width:20%;

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


</style>
<div class="header">

  <div class="row">
    <div class="col-sm-6">
         <h1>
		    <div class="tekstNaglowka">
				Pole namiotowe
		    </div>
		</h1>
    </div>
    <div class="col-sm-3">
		<div class="standardowyPrzycisk">
			Kontakt
		</div>
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
Nazwa
</div>
<div class = "miejscowosc">
Miejscowosc
</div>
</div>

<div class = "elementListy">
	<div class = "id">
		1
	</div>
	<div class = "nazwa">
		Dupa
	</div>
	<div class = "miejscowosc">
		Praga
	</div>
	<span class = "rozwin">
		Dowiedz siÄ wiÄcej!
	</span>
	<span class = "zwin">
		ZwiÅ!
	</span>
	<div class = "dodatkoweInfo">
		<opis>
			</br>Malownicza dolina xD hehe lol x2
		</opis>
	</div>
</div>
<div class = "elementListy">
	<div class = "id">
		2
	</div>
	<div class = "nazwa">
		Praga
	</div>
	<div class = "miejscowosc">
		Praga
	</div>
	<span class = "rozwin">
		Dowiedz siÄ wiÄcej!
	</span>
		<span class = "zwin">
		ZwiÅ!
	</span>
	<div class = "dodatkoweInfo">
		<opis>
			</br>opis
		</opis>
	</div>
</div>
<div class = "elementListy">
	<div class = "id">
		3
	</div>
	<div class = "nazwa">
		Zacisze
	</div>
	<div class = "miejscowosc">
		Praga
	</div>
	<span class = "rozwin">
		Dowiedz siÄ wiÄcej!
	</span>
		<span class = "zwin">
		ZwiÅ!
	</span>
	<div class = "dodatkoweInfo">
		<opis>
			</br>opos
		</opis>
	</div>
</div>
</div>

</div>
<div class="col-sm-6">
<h1>
Chcesz dodaÄ nowe pole? 
</h1>
<div class="col-sm-6">
		<div class="niebieskiStandardowyPrzycisk" id = "czerwony">
			Kliknji tutaj!
		</div>
</div>
</div>