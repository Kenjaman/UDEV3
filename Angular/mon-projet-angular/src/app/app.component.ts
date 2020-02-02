import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Personne} from './model/personne';
import {TPTableauPersonComponent} from './tp-tableau-person/tp-tableau-person.component';
import {error} from "util";
import {NgForm} from "@angular/forms";
import {AppareilService} from "./services/appareil.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  /**
   fruit="";
   titre="Calcul IMC";
   poids:number;
   taille:number;
   poidIdeal:number;
   IMC:number;
   imcJudgement:string;

   onAffiche(){
    this.IMC = this.getIMC(this.poids,this.taille);
    this.imcJudgement = this.getResultIMC();
    this.getPoidIdeal();
  }
   getIMC(poids,taille):any{
    this.IMC=poids/(taille*taille);
    return isNaN(this.IMC)?'non définie':this.IMC;
  }
   getResultIMC():string{
    if(this.IMC<=18.5)
      return "Trop maigre";
    else if(this.IMC>=25){
      return "En surpoid";
    }else {
      return "Normal";
    }
  }
   getPoidIdeal(){
    this.poidIdeal =  20*(this.taille * this.taille);
  }
   tab:any[]=[];
   onAjouter():void{
    this.tab.push(this.fruit);
    this.fruit="";
  }

   v2:any={
    couleur:'vert',
    marque:'BMW'
  };
   //creation d'un objet sans type et a la volée :

   onTest():void{
    let v1:any={};
    v1.couleur="rouge";
    v1.marque="Tesla";
    this.tab.push(v1);
    this.tab.push(this.v2);
    console.log(v1);
    console.log(this.v2);
    console.log(this.tab);
  }**/ //Premiere partie de cours

  /**
   * tab:Personne[]=[
   {nom:'DOE',prenom:'JOHN'},
   {nom:'Roux',prenom:'Kénan'}
   ];
   prenom:string ="";
   nom:string="";
   ngOnInit(){ // Methode appelée automatiquement par Angular au chargement du component
   // let p = {nom:'cage',prenom:'nicolas'};
    let p:Personne = new Personne('Nicolas','Cage');
    this.tab.push(p);
  }
   onAjouter():void{
    let person:any={};
    person.nom=this.nom;
    person.prenom=this.prenom;
    this.tab.push(person);
    this.nom="";
    this.prenom="";
  }
   onEnlever(index:number):void{
    this.tab.splice(index,1);
  }
   }
   **/ // Deuxieme partie de cours sur les classes

   /*//httpClient:HttpClient
   film:string;
   tab:any[];
   tabFavoris:any[] =[];
   constructor(private httpClient:HttpClient){
    	}
   ngOnInit(){
    		this.lecture();
    	}
   onSearch(){
    		let url ='http://www.omdbapi.com/?s='+ this.film+'&apikey=efdc2275';
    		this.film='';
    		this.httpClient.get<any>(url).subscribe(
    			(response) => {
    				this.tab = response.Search;
    			},
    			(error)=>{
    				console.log('error');
    			}
    			);

    	}
   onAjouter(i:number){
    		// j'ajoute mon film ds les favoris
    		this.tabFavoris.push(this.tab[i]);
    		this.tab.splice(i,1);
    		this.ecriture();
    	}
   onEnlever(i:number){
    		this.tabFavoris.splice(i,1);
    		this.ecriture();
    	}

   ecriture(){
    		let url ='https://gestion-equipe.firebaseio.com/films.json';
    		this.httpClient.put(url,this.tabFavoris).subscribe(
    			(response) => {
    				console.log('Ecriture OK !!');
    			},
    			(error)=>{
    				console.log('error');
    			}
    			);
    	}
   lecture(){
    		let url ='https://gestion-equipe.firebaseio.com/films.json';
    		this.httpClient.get<any[]>(url).subscribe(
    			(response) => {
    				if (response != undefined)
    				this.tabFavoris = response;
    			},
    			(error)=>{
    				console.log('error');
    			}
    			);

    	}*/
    // TP Connexion API

  /**
   * affiche:boolean=true;
   couleur:string='r';
   onSwitch():void{
    if(this.couleur=='r'){
      this.couleur='b';
    }else{
      this.couleur='r';
    }
  }

   getCouleur():string{
    if(this.couleur=='b'){
      return 'DodgerBlue';
    }else{
      return 'tomato';
    }
  }
   }**/ //TP sur [ngClass]

  /**
  tabAppareil:any[];
  nomAppareil:string;
  etatAppareil:string;
  constructor(private appareilService:AppareilService) {

  }
  ngOnInit(){
    this.tabAppareil=this.appareilService.tabAppareil;
  }
  onAllumer(){
    //tout allumer
      this.appareilService.switchAllOn();

  }

  onEteindre(){
      this.appareilService.switchAllOff();

  }

  onAjoute(){
    this.appareilService.tabAppareil.push({name:this.nomAppareil,status:this.etatAppareil});
    this.etatAppareil='';
    this.nomAppareil='';
  }*/ // TP Appareils


}
