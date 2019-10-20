package fr.epsi.udev.ex16;

import java.util.ArrayList;
import java.util.List;
public class ParcVehicule {

	private List <Moto> motos;
	private List <Camion> camion;
	private List <Voiture> voitures;
	private List <Tracteur> tracteurs;
	
	public ParcVehicule(List<Moto> motos, List<Camion> camion, List<Voiture> voitures, List<Tracteur> tracteurs ) {
		super();
		this.motos = motos;
		this.camion = camion;
		this.voitures = voitures;
		this.tracteurs = tracteurs;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("Parc de vehicule : \n" );
		str.append("Nombre de vehicules dans le parc : "+this.getNbVehicule()+"\n");
		str.append("Nombre de Voitures : "+this.getNbVoitures()+"\n");
		str.append("Nombre de Motos : "+this.getNbMotos()+"\n");
		str.append("Nombre de Camions :"+this.getNbCamion()+"\n");
		str.append("Nombre de Tracteurs :"+this.getNbTracteurs()+"\n");
		
		return str.toString();
	}
	
	public int getNbVehicule() {
		return this.getNbMotos()+this.getNbCamion()+this.getNbVoitures()+this.getNbTracteurs();
	}
	public int getNbMotos() {
		return motos.size();
	}
	public void setMotos(List<Moto> motos) {
		this.motos = motos;
	}
	public int getNbCamion() {
		return camion.size();
	}
	public void setCamion(List<Camion> camion) {
		this.camion = camion;
	}
	public int getNbVoitures() {
		return voitures.size();
	}
	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	public int getNbTracteurs() {
		return tracteurs.size();
	}

	public void setTracteurs(List <Tracteur> tracteurs) {
		this.tracteurs = tracteurs;
	}
	

 }
