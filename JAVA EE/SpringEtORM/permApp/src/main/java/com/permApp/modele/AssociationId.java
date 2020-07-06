package com.permApp.modele;

import java.io.Serializable;

public class AssociationId implements Serializable{
	protected Long id_plante1;
	protected Long id_plante2;
	
	public AssociationId() {
	}
	
	public AssociationId(Long id_plante1, Long id_plante2) {
		super();
		this.id_plante1 = id_plante1;
		this.id_plante2 = id_plante2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_plante1 == null) ? 0 : id_plante1.hashCode());
		result = prime * result + ((id_plante2 == null) ? 0 : id_plante2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssociationId other = (AssociationId) obj;
		if (id_plante1 == null) {
			if (other.id_plante1 != null)
				return false;
		} else if (!id_plante1.equals(other.id_plante1))
			return false;
		if (id_plante2 == null) {
			if (other.id_plante2 != null)
				return false;
		} else if (!id_plante2.equals(other.id_plante2))
			return false;
		return true;
	}
	
	


}
