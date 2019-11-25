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
				row.setAttribute("tag", lesSeries[i].id);
			}
		}
		else {
			console.log("je n'ai pas mon fichier" + this.responseText);
		}
	};
	xmlhttp.open("GET", "https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=series");
	xmlhttp.send();
};

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

