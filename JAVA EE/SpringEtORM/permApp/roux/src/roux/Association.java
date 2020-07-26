package roux;

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

	private String relation;

	//bi-directional many-to-one association to Plante
	@ManyToOne
	@JoinColumn(name="id_plante1")
	private Plante plante1;

	//bi-directional many-to-one association to Plante
	@ManyToOne
	@JoinColumn(name="id_plante2")
	private Plante plante2;

	public AssociationPK getId() {
		return this.id;
	}

	public void setId(AssociationPK id) {
		this.id = id;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
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