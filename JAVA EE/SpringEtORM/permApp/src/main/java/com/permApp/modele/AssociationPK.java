package com.permApp.modele;


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
//
//import java.io.Serializable;
//
//import javax.persistence.Embeddable;
//
//@Embeddable
//public class AssociationId implements Serializable{
//	protected Long id_plante1;
//	protected Long id_plante2;
//	
//	public AssociationId() {
//	}
//	
//	public AssociationId(Long id_plante1, Long id_plante2) {
//		super();
//		this.id_plante1 = id_plante1;
//		this.id_plante2 = id_plante2;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id_plante1 == null) ? 0 : id_plante1.hashCode());
//		result = prime * result + ((id_plante2 == null) ? 0 : id_plante2.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		AssociationId other = (AssociationId) obj;
//		if (id_plante1 == null) {
//			if (other.id_plante1 != null)
//				return false;
//		} else if (!id_plante1.equals(other.id_plante1))
//			return false;
//		if (id_plante2 == null) {
//			if (other.id_plante2 != null)
//				return false;
//		} else if (!id_plante2.equals(other.id_plante2))
//			return false;
//		return true;
//	}
//	
//	
//
//
//}
