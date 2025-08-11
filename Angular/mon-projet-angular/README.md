# Mon Projet Angular - Collection d'Exercices

Ce projet a été généré avec [Angular CLI](https://github.com/angular/angular-cli) version 8.3.23 et sert de collection pour divers exercices et travaux pratiques réalisés durant la formation.

## Contenu du projet

Ce n'est pas une application unique, mais plutôt un bac à sable contenant plusieurs mini-projets et démonstrations, notamment :

*   **Gestionnaire d'appareils :** Une interface simple pour allumer, éteindre et ajouter des appareils. (Voir `app/appareil/`)
*   **Tableau de personnes :** Un composant pour afficher une liste de personnes. (Voir `app/tp-tableau-person/`)
*   **Recherche de films :** Une fonctionnalité (actuellement commentée dans `app.component.html`) pour rechercher des films via l'API OMDb et les ajouter à une liste de favoris.
*   **Jeu de mémoire :** Un petit jeu de cartes memory.
*   **Divers :** D'autres exercices sur les formulaires, l'IMC, etc.

Le composant actif au démarrage est `<app-tp-tableau-person>`. Pour explorer les autres fonctionnalités, il est nécessaire de modifier `src/app/app.component.html`.

---

## Development server

First, install the dependencies:
```sh
npm install
```
Then, run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
