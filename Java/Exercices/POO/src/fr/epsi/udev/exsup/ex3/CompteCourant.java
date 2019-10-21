package fr.epsi.udev.exsup.ex3;

public class CompteCourant extends Compte {
	private double decouvertAuto;

	public CompteCourant(double decouvertAuto) {
		super();
		this.decouvertAuto = decouvertAuto;
	}

	public double getDecouvertAuto() {
		return decouvertAuto;
	}

	public void setDecouvertAuto(double decouvertAuto) {
		this.decouvertAuto = decouvertAuto;
	}
	
	public void retire(double montant) throws IllegalArgumentException {
		if(this.getSolde()-montant<this.getDecouvertAuto()) {
			this.setSolde(this.getSolde()-montant);
		}else
			throw new IllegalArgumentException("Le solde est insuffisant");
	}
}
