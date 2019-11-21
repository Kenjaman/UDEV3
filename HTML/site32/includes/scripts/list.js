var xmlhttp = new XMLHttpRequest();
xmlhttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
		var text= this.responseText;
		var lesSeries = JSON.parse(text);
		var liSeries=document.getElementById("bodyTableauSeries");
		for(var i=0;i<lesSeries.length;i++){
		  var row = liSeries.insertRow(i);
		  var cell1 = row.insertCell(0);
		  var cell2 = row.insertCell(1);
		  cell1.innerHTML = lesSeries[i].nom;
		  cell2.innerHTML = lesSeries[i].anneeparution;
		}
	}
	else {
	console.log("je n'ai pas mon fichier"+this.responseText);
}
	
};
xmlhttp.open("GET", "https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=series");
xmlhttp.send();