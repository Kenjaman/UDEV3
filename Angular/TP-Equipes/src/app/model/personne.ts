export class Personne {
  //prenom:string;
  //nom:string;
  // Parametre public : pas besoin de les declarer ni les instancier, cela est fait automatiquement
  // 3 Constructeurs en un
  constructor(public prenom:string='',public nom:string='',public age:number=0) {
    //this.prenom=prenom;
    //this.nom=nom;
  }
}
