package com.permApp.modele;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity @IdClass(AssociationId.class)
public class Association {
	
	@Id
	private Long id_plante1;
	@Id
	private Long id_plante2;
	
	private Qualite relation;
	
	
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
	public Qualite getRelation() {
		return relation;
	}
	public void setRelation(Qualite relation) {
		this.relation = relation;
	}

}
