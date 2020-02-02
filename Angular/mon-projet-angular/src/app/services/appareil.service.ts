export class AppareilService{
  tabAppareil:any[]=[
    {name:'Machine a café', status:'allumé'},
    {name:'TV', status:'allumé'},
    {name:'Xbox', status:'éteint'}
  ];

  switchAllOn(){
    for(let a of this.tabAppareil){
      a.status = 'allumé';
    }
  }

  switchAllOff(){
    for(let a of this.tabAppareil){
      a.status = 'éteint';
    }
  }

  switchOneOn(i:number){
    this.tabAppareil[i].status='allumé';
  }

  switchOneOff(i:number){
    this.tabAppareil[i].status='éteint';

  }
}
