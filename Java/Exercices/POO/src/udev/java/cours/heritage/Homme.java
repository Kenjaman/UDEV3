package udev.java.cours.heritage;

public class Homme extends Humain {

	private String barbe;

		public Homme() {
			super();
		}

		public Homme(String nom, String prenom, String barbe) {
			super(nom, prenom);
			this.barbe=barbe;
		}
		
		public String getBarbe() {
			return barbe;
		}

		public void setBarbe(String barbe) {
			this.barbe = barbe;
		}

		@Override
		public void seDeplacer() {
			System.out.println("L'homme se déplace en marchant");
			super.seDeplacer();
		}

		@Override
		public void manger() {
			System.out.println("L'homme mange avec ses doigts");
		}
	}
