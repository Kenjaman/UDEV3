package com.permApp.modele;

import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Association {
	
//	//Creer un id technique unique
//	@Id
//	private Long id_assoc;

	@EmbeddedId
	private AssociationId id_assoc;
	@OneToMany
	private List<Plante> id_plante1;
	@OneToMany
	private List<Plante> id_plante2;
	
	

	@Enumerated(EnumType.STRING)
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
