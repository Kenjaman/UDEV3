let cbj = document.getElementsByName("cbJour")[0];
for(let i=1;i<=31;i++) {
	cbj.options.add(new Option(i, i));
}
let cbm = document.getElementsByName("cbMois")[0];
tabMois= ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];
for(let i=0;i<=11;i++) {
	cbm.options.add(new Option(tabMois[i],i+1));
}
let cba = document.getElementsByName("cbAnnee")[0];
for(let i=2049;i>=1929;i--) {
	cba.options.add(new Option(i,i));
}

var xmlHttp = new XMLHttpRequest();
xmlHttp.onreadystatechange=function(){
	if(this.status==200 && this.readyState==4){
		var text= this.responseText;
		var lesReals = JSON.parse(text);
		var cbReal=document.getElementsByName("realisateur")[0];
		console.log(lesReals);
		for(var i=0;i<lesReals.length;i++){
			var id=lesReals[i].id;
			var libelle=lesReals[i].nom+" "+lesReals[i].prenom;
			cbReal.options.add(new Option(libelle,id));
		}
	}else {
		console.log("je n'ai pas mon fichier"+this.responseText);
	}
};
xmlHttp.open("GET","https://www.devatom.net/formation/UDEV3/APINetflix/api.php?data=personnes&idfonction=4");
xmlHttp.send();

function ajoutReal(){
	let newReal=prompt("Nouveau réalisateur");
	let maListe = document.getElementsByName("realisateur")[0];
	let existe=false;
	let i=0;
	do {
		existe=(newReal === maListe.options[i].text);
		i++;
	}while(!existe && i<maListe.options.length);
	if(!existe && newReal.trim()!=="")
		maListe.options.add(new Option(newReal, maListe.options.length));
	else
		i--;
	maListe.options[i].selected=true;
}

function verifForm(){
	let nbErr=0;
	let champTitre = document.getElementById("titre_");
	if(champTitre.value.trim()===""){
		champTitre.focus();
		colore(champTitre);
		nbErr++;
	}
	let champJour = document.getElementsByName("cbJour")[0];
	let champMois= document.getElementsByName("cbMois")[0];
	let champAnnee=document.getElementsByName("cbAnnee")[0];
	if(champJour.selectedIndex===0 ){
		colore(champJour);
		champJour.focus();
		nbErr++;
	}
	if(champMois.selectedIndex===0){
		colore(champMois);
		champMois.focus();
		nbErr++;
	}
	if(champAnnee.selectedIndex===0){
		colore(champAnnee);
		champAnnee.focus();
		nbErr++;
	}

	if(!oneChecked()){
		let checkboxes = document.getElementById('checkGenres');
		checkboxes.style.border='solid 1px red';
		nbErr++;
	}
	return nbErr===0;
}
function oneChecked(){
	let checkboxes = document.querySelectorAll("#checkGenres input[type=checkbox]:checked");
   return checkboxes.length!==0
}
function colore(input){
	input.style.backgroundColor='red';
}
function decolore(input) {
	input.style.backgroundColor = 'white';
}
function decoloreCheck(input){
	input.parentNode.style.borderStyle='none';
}
