package monopoly.core;

public class Plateau {
	public String [] emplacements;
	
	public Plateau(String [] emplacements) {
		this.emplacements = emplacements.clone();
	}

	public String getEmplacement(int position) {
		return emplacements[position];
	}
	
	public int getNbEmplacement() {
		return this.emplacements.length;
	}
	
}
