import { Component, OnInit,Input } from '@angular/core';
import {EquipeService} from "../services/equipe.service";
import {Equipe} from "../model/equipe";

@Component({
  selector: 'app-equipe',
  templateUrl: './equipe.component.html',
  styleUrls: ['./equipe.component.scss']
})
export class EquipeComponent implements OnInit {
@Input() equipe:Equipe;
@Input() i:number;
  constructor(private equipeService:EquipeService) { }

  ngOnInit() {
    console.log(this.equipe);
  }

  onDeleteEquipe(){
    this.equipeService.deleteEquipe(this.i);
  }

  onDeletePersonne(id) {
    this.equipeService.supprimerMembre(id,this.i);
  }
}
