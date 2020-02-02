import { Component, OnInit, Input } from '@angular/core';
import {AppareilService} from "../services/appareil.service";

@Component({
  selector: 'app-appareil',
  templateUrl: './appareil.component.html',
  styleUrls: ['./appareil.component.scss']
})
export class AppareilComponent implements OnInit {
@Input() name:string;
@Input() status:string;
@Input() i:number;
  constructor(private appareilService:AppareilService) {

  }

  ngOnInit() {
  }

  onAllumer() {
    this.appareilService.switchOneOn(this.i);
  }

  onEteindre(){
    this.appareilService.switchOneOff(this.i);
  }
}
