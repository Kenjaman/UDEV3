import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EquipeComponent } from './equipe/equipe.component';
import {EquipeService} from "./services/equipe.service";
import { FormsModule} from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    EquipeComponent
  ],
  imports: [
  	FormsModule,
    BrowserModule
  ],
  providers: [EquipeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
