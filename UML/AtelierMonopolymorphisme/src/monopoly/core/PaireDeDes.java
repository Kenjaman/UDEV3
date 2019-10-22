package monopoly.core;

public class PaireDeDes {
  Dice[] des;
  
  public PaireDeDes(int nbFace) {
		  des = new Dice[] {new Dice(nbFace), new Dice(nbFace)};
  }
  
  public boolean estDouble() {
	  return this.des[0].getValue() == this.des[1].getValue();
  }
  public void lancer() {
	  des[0].lancer();
	  des[1].lancer();
  }
  
  public int getResultat(int indice) {
	  if(indice >1 )
		  throw new IndexOutOfBoundsException("Dé 0 ou 1");
	  return this.des[indice].getValue();
	 }
  
  public int getTotal() {
	  int res=0;
	  for(Dice de : des)
		  res+=de.getValue();
	  return res;
  }
}
