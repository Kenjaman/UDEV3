import {Equipe} from "../model/equipe";
import {Personne} from "../model/personne";

export class EquipeService{
  tabEquipe:Equipe[] = [];

  ajouterEquipe(nom:string){
    // e:any = { name:this.equipe, tabPersonne:[] };
    let equipe:Equipe=new Equipe();
    equipe.teamName = nom;
    equipe.tabPersonnes =[{nom:'killroy',prenom:'Johny',age:25}];
    this.tabEquipe.push(equipe);
    console.log(equipe);
  }

  ajouterMembre(personne:Personne,idEquipe:number){
    this.tabEquipe[idEquipe].tabPersonnes.push(personne);

  }
  supprimerMembre(index:number,idEquipe:number){
    this.tabEquipe[idEquipe].tabPersonnes.splice(index,1);
  }
  deleteEquipe(index:number){
    this.tabEquipe.splice(index,1);
  }
}
