/**
 * 
 */
package fr.epsi.udev.ex19;

/**
 * @author Kénan
 *
 */
public class Representant extends Vendeur {

	/**
	 * 
	 */
	public Representant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param prenom
	 * @param nom
	 * @param age
	 * @param string
	 */
	public Representant(String prenom, String nom, int age, String dateEntree, int ca) {
		super(prenom, nom, age, dateEntree, ca);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculerSalaire() {
		return super.calculerSalaire()+400;
	}

}
