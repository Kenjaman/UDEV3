import { Component, OnInit } from '@angular/core';
import { Personne} from "../model/personne";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-tp-tableau-person',
  templateUrl: './tp-tableau-person.component.html',
  styleUrls: ['./tp-tableau-person.component.scss']
})
export class TPTableauPersonComponent implements OnInit {

  tabPersonne:any[]=[];
  nom:string;
  prenom:string;
  id:number;
  //sexe:string='homme';

  constructor(private httpClient:HttpClient) {

  }

 /* tab:Personne[]=[
    new Personne('Rick','Sanchez', 'homme'),
    new Personne('Sanchez','Morty','homme')
  ];*/
  ngOnInit() {
    //let p:Personne = new Personne('Jessica','Juste','femme');
    this.onLecture();
    console.log(this.tabPersonne);
  }

  onEnlever(index:number):void{
    let url= 'http://localhost/demo-api/supprimer.php';
    let personne = {id:index,nom:this.nom,prenom:this.prenom};
    this.httpClient.post(url,personne).subscribe(
      (response) => {
        console.log(response);
        alert('Suppression OK');

      },
      (error)=>{
        console.log('error');
        console.log(error);
      },
      ()=>{this.onLecture();}
    );

  }
  /*onAjouter():void{ // Methode sans persistance
    let person:Personne={nom:this.nom,
      prenom:this.prenom,
      sexe :this.sexe};
    this.tab.push(person);
    this.nom="";
    this.prenom="";
    this.sexe="";
  }*/


  onLecture() {
    let url = "http://localhost/demo-api/list-personne.php";
    this.httpClient.get<any>(url).subscribe(
      (response) => {
        if (response != undefined)
          this.tabPersonne = response;
        console.log(response);

      },
      (error) => {
        console.log("error");
      }
    )
  }

  onEcriture(){
    let url= 'http://localhost/demo-api/ecriture.php';
    let personne = {nom:this.nom,prenom:this.prenom};
    this.httpClient.post(url,personne).subscribe(
      (response) => {
        console.log(response);
        console.log('Ecriture OK');
        this.nom='';
        this.prenom='';
      },
      (error)=>{
        console.log('error');
        console.log(error);
      },
      ()=>{this.onLecture();}
    );

  }
}
