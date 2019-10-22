package monopoly.core;

public class Joueur {

	private int capital;
	private int posMax;
	private int position;
	
	public Joueur(int capital, int posMax) {
		this.capital=capital;
		this.posMax= posMax;
	}
	
	public int avancer(PaireDeDes des) {
		if(this.getPosition()+des.getTotal() < this.posMax) {
			this.setPosition(this.getPosition()+des.getTotal());
			return this.getPosition();
		}else {
			this.setPosition(this.getPosition()+des.getTotal()-this.posMax);
			this.gagner(200);
			System.out.println("Vous passer par la case départ vous gagner 200$");
			return this.getPosition();
		}
	}

	public int reculer(int nbCase) {
		this.setPosition((this.getPosition()-nbCase)<0 ? (this.getPosition()-nbCase)%this.posMax : this.getPosition()-nbCase);
		return this.getPosition();
	}
	
	public void gagner(int montant) {
		this.capital+=montant;
	}
	
	public void payer(int montant) throws BanquerouteException{
		if(this.getCapital()-montant<=0)
			throw new BanquerouteException("Hypothèquez ! Vous êtes ruiné !",montant,this);
		else {
			this.capital-=montant;
		}
	}
	
	public void teleportation(int position) {
		this.setPosition(position);
	}

	public int getCapital() {
		return capital;
	}

	public int getPosMax() {
		return posMax;
	}

	public void setPosMax(int posMax) {
		this.posMax = posMax;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
