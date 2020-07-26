package roux;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Plante database table.
 * 
 */
@Entity
@NamedQuery(name="Plante.findAll", query="SELECT p FROM Plante p")
public class Plante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	private Date dateCreation;

	@Lob
	private byte[] image;

	private String nom;

	//bi-directional many-to-one association to Association
	@OneToMany(mappedBy="plante1")
	private List<Association> associations1;

	//bi-directional many-to-one association to Association
	@OneToMany(mappedBy="plante2")
	private List<Association> associations2;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Association> getAssociations1() {
		return this.associations1;
	}

	public void setAssociations1(List<Association> associations1) {
		this.associations1 = associations1;
	}

	public Association addAssociations1(Association associations1) {
		getAssociations1().add(associations1);
		associations1.setPlante1(this);

		return associations1;
	}

	public Association removeAssociations1(Association associations1) {
		getAssociations1().remove(associations1);
		associations1.setPlante1(null);

		return associations1;
	}

	public List<Association> getAssociations2() {
		return this.associations2;
	}

	public void setAssociations2(List<Association> associations2) {
		this.associations2 = associations2;
	}

	public Association addAssociations2(Association associations2) {
		getAssociations2().add(associations2);
		associations2.setPlante2(this);

		return associations2;
	}

	public Association removeAssociations2(Association associations2) {
		getAssociations2().remove(associations2);
		associations2.setPlante2(null);

		return associations2;
	}

}