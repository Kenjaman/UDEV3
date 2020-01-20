function getListeSeries(){
	var xmlhttp = getAjaxRequestObject();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var text= this.responseText;
			var lesSeries = JSON.parse(text);
			var liSeries=document.getElementById("bodyTableauSeries");

			for(var i=0;i<lesSeries.length;i++){

				var row = liSeries.insertRow(i);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cellSaison = row.insertCell(2);
				cell1.innerText = lesSeries[i].nom;
				cell2.innerText = lesSeries[i].anneeparution;
				getNbSaisons(lesSeries[i].id,cellSaison);
				row.setAttribute("class","ligneTab");
				row.setAttribute("tag", lesSeries[i].id);
				liSeries.append(row);
			}
		}
		else {
			console.log("je n'ai pas mon fichier" + this.responseText);
		}
	};
	xmlhttp.open("GET", "https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=series");
	xmlhttp.send();
}

function getNbSaisons(id, cell){
	var nbSaison =0;
	var xmlHttpSaisons = getAjaxRequestObject();
	xmlHttpSaisons.onreadystatechange = function () {
		if(this.readyState === 4 && this.status === 200){
			try{
				nbSaison = JSON.parse(this.responseText).length;
			}catch (e) {
				nbSaison=0;
			}
			cell.innerText=nbSaison;
		}
	};
	xmlHttpSaisons.open("GET", "https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=saisons&idserie="+id);
	xmlHttpSaisons.send();

}


function getListeSaisons(tableSaisons, idSerie) {
	var xmlhttp = getAjaxRequestObject();
	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var text= this.responseText;
			var lesSaisons = JSON.parse(text);
			var liSaisons=tableSaisons;
			for(var i=0;i<lesSaisons.length;i++){

				var row = liSaisons.insertRow(i);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cellSaison = row.insertCell(2);
				cell1.innerText = lesSaisons[i].numero;
				cell2.innerText = lesSaisons[i].annee_diffusion;
				getNbEpisodes(lesSaisons[i].id,cellSaison);
				row.setAttribute("class","ligneTabSaison");
				row.setAttribute("tag", lesSaisons[i].id);
				liSaisons.append(row);
			}
		}
		else {
			console.log("je n'ai pas mon fichier" + this.responseText);
		}
	};
	xmlhttp.open("GET", "https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=saisons&idserie="+idSerie);
	xmlhttp.send();
}

function getNbEpisodes(id, cellSaison) {
	var nbEpisodes =0;
	var xmlHttpSaisons = getAjaxRequestObject();
	xmlHttpSaisons.onreadystatechange = function () {
		if(this.readyState === 4 && this.status === 200){
			try{
				nbEpisodes = JSON.parse(this.responseText).length;
				console.log(nbEpisodes);
			}catch (e) {
				nbEpisodes=0;
			}
			cellSaison.innerText=nbEpisodes;
		}
	};
	console.log("https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=episodes&idsaison="+id);
	xmlHttpSaisons.open("GET", "https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=episodes&idsaison="+id);
	xmlHttpSaisons.send();

}

