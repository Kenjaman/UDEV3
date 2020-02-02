import {Component, Input, OnInit} from '@angular/core';
import {EquipeService} from "./services/equipe.service";
import {Personne} from "./model/personne";
import {Equipe} from "./model/equipe";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
 @Input() nomEquipeInput:string;
  @Input() nom:string;
  @Input() prenom:string;
  @Input() age:number;
  @Input() idEquipe:number;

 tabEquipe:Equipe[];
  constructor(private equipeService:EquipeService) {
 }

 ngOnInit(): void {
   this.tabEquipe=this.equipeService.tabEquipe;
 }

  onAjouterEquipe(){
 	this.equipeService.ajouterEquipe(this.nomEquipeInput);
 	this.nomEquipeInput='';
 }

 onAjouterMembre(){
   this.equipeService.ajouterMembre(new Personne(this.nom,this.prenom,this.age),this.idEquipe);
   this.nom='';this.prenom = '';
   this.age=undefined;this.idEquipe=undefined;
 }

}
