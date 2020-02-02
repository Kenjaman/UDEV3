import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";// <-- étape 2 (automatique avec WebStorm)
import { TPTableauPersonComponent } from './tp-tableau-person/tp-tableau-person.component';
import {HttpClientModule} from "@angular/common/http";
import {AppareilComponent} from './appareil/appareil.component';
import {AppareilService} from "./services/appareil.service";

@NgModule({
  declarations: [
    AppComponent,
    AppareilComponent,
    TPTableauPersonComponent
  ],
  imports: [
    BrowserModule,
    FormsModule, // <-- étape 1
    HttpClientModule
  ],
  providers: [ // Ici on met les services
    AppareilService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
