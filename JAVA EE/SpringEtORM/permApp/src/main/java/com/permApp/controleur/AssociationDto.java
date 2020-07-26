package com.permApp.controleur;

import com.permApp.modele.Relation;

public class AssociationDto {

	private Long id_plante1;
	private Long id_plante2;
	private Relation relation;

	
	public Long getId_plante1() {
		return id_plante1;
	}
	public void setId_plante1(Long id_plante1) {
		this.id_plante1 = id_plante1;
	}
	public Long getId_plante2() {
		return id_plante2;
	}
	public void setId_plante2(Long id_plante2) {
		this.id_plante2 = id_plante2;
	}
	public Relation getRelation() {
		return relation;
	}
	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	
}
