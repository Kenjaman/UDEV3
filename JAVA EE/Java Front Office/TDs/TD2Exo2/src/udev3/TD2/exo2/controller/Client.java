package udev3.TD2.exo2.controller;

import java.beans.Beans;

public class Client extends Beans {

	private Integer numClient;
	private String nom;
	private String adresse;
	private String cp;
	private String ville;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(Integer numClient, String nom, String adresse, String cp, String ville) {
		this();
		this.numClient = numClient;
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}
	
	public Integer getNumClient() {
		return numClient;
	}
	public void setNumClient(Integer numClient) {
		this.numClient = numClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
