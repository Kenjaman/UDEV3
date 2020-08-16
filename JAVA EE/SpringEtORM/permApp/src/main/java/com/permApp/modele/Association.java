package com.permApp.modele;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Association database table.
 * 
 */
@Entity
@NamedQuery(name="Association.findAll", query="SELECT a FROM Association a")
public class Association implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AssociationPK id;

	private Relation relation;

	//bi-directional many-to-one association to Plante
	@ManyToOne
	@JoinColumn(name="id_plante1", insertable=false, updatable=false)
	private Plante plante1;

	//bi-directional many-to-one association to Plante
	@ManyToOne
	@JoinColumn(name="id_plante2", insertable=false, updatable=false)
	private Plante plante2;

	public AssociationPK getId() {
		return this.id;
	}

	public void setId(AssociationPK id) {
		this.id = id;
	}

	public Relation getRelation() {
		return this.relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public Plante getPlante1() {
		return this.plante1;
	}

	public void setPlante1(Plante plante1) {
		this.plante1 = plante1;
	}

	public Plante getPlante2() {
		return this.plante2;
	}

	public void setPlante2(Plante plante2) {
		this.plante2 = plante2;
	}

}
//import java.util.List;
//
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
//@Entity
//public class Association {
//	
////	//Creer un id technique unique
////	@Id
////	private Long id_assoc;
//
//	@EmbeddedId
//	private AssociationId id_assoc;
//	@OneToMany
//	private List<Plante> id_plante1;
//	@OneToMany
//	private List<Plante> id_plante2;
//	
//	
//
//	@Enumerated(EnumType.STRING)
//	private Relation relation;
//	
//	
//	public Long getId_plante1() {
//		return id_plante1;
//	}
//	public void setId_plante1(Long id_plante1) {
//		this.id_plante1 = id_plante1;
//	}
//	public Long getId_plante2() {
//		return id_plante2;
//	}
//	public void setId_plante2(Long id_plante2) {
//		this.id_plante2 = id_plante2;
//	}
//	public Relation getRelation() {
//		return relation;
//	}
//	public void setRelation(Relation relation) {
//		this.relation = relation;
//	}
//
//}
