package roux;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Association database table.
 * 
 */
@Embeddable
public class AssociationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_plante1", insertable=false, updatable=false)
	private int idPlante1;

	@Column(name="id_plante2", insertable=false, updatable=false)
	private int idPlante2;

	public int getIdPlante1() {
		return this.idPlante1;
	}
	public void setIdPlante1(int idPlante1) {
		this.idPlante1 = idPlante1;
	}
	public int getIdPlante2() {
		return this.idPlante2;
	}
	public void setIdPlante2(int idPlante2) {
		this.idPlante2 = idPlante2;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssociationPK)) {
			return false;
		}
		AssociationPK castOther = (AssociationPK)other;
		return 
			(this.idPlante1 == castOther.idPlante1)
			&& (this.idPlante2 == castOther.idPlante2);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPlante1;
		hash = hash * prime + this.idPlante2;
		
		return hash;
	}
}