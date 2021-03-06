package testJDBC;

import java.util.Date;

public class Utilisateur {
	private Integer id;
	private String login;
	private Date inscription;
	private boolean actif;

	public Utilisateur(Integer id, String login, Date inscription, boolean actif) {
		super();
		this.id = id;
		this.login = login;
		this.inscription = inscription;
		this.actif = actif;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getInscription() {
		return inscription;
	}
	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", inscription=" + inscription + ", actif=" + actif + "]";
	}

}