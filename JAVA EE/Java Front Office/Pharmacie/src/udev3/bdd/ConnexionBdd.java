package udev3.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udev3.beans.Client;
import udev3.beans.Medicament;

public class ConnexionBdd {

	public ConnexionBdd() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Client> getClients() {
		ArrayList<Client> clients = new ArrayList<Client>();
		String requete = "SELECT * FROM client;";

		try(Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacie", "root", "");
				Statement statement = connexion.createStatement();
				ResultSet resultSet = statement.executeQuery(requete)){

			while(resultSet.next()) {
				Client client = new Client(
						resultSet.getString("nom"),
						resultSet.getDouble("credit"));
				clients.add(client);
			}
		}catch (Exception e) {
			System.out.println("boulette en bdd !");
		}

		return clients;
	}

	public ArrayList<Medicament> getMedicaments() {
		ArrayList<Medicament> medocs = new ArrayList<Medicament>();
		String requete = "SELECT * FROM medicament;";

		try(Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacie", "root", "");
				Statement statement = connexion.createStatement();
				ResultSet resultSet = statement.executeQuery(requete)){
			while(resultSet.next()) {
				Medicament medicament = new Medicament(
						resultSet.getString("nom"),
						resultSet.getDouble("prix"),
						resultSet.getInt("stock"));
				medocs.add(medicament);
			}
		}catch (Exception e) {
			System.out.println("boulette en bdd medocs!");
		}

		return medocs;
	}

	public void achat(String nomClient, String nomMedoc, int quantite, int paiement) throws Exception {
		Client client = this.lireClient(nomClient);
		Medicament medicament = this.lireMedicament(nomMedoc);
		if (quantite <= medicament.getStock()) {
			medicament.diminuerStock(quantite);
			client.augmenterCredit((medicament.getPrix() * quantite) - paiement);
			updateStockMed(medicament);
			updateCreditCli(client);
		} else {
			throw new Exception("Achat Impossible. Quantité insuffisante");
		}
	}

	public void approvisionnement(String nom, int qte) throws Exception {
		Medicament medicament = this.lireMedicament(nom);
		int quantite = qte;
		medicament.augmenterStock(quantite);
		this.updateStockMed(medicament);
	}

	private void updateStockMed(Medicament medicament) {
		String requete = "UPDATE medicament SET stock = ? WHERE nom = ?";
		try(Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacie", "root", "");
				PreparedStatement preparedStatement = connexion.prepareStatement(requete)){

			preparedStatement.setInt(1, medicament.getStock());
			preparedStatement.setString(2, medicament.getNom());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			System.out.println("boulette maj medoc en bdd !");
			System.out.println(e.getMessage());
		}
	}
	
	private void updateCreditCli(Client client) {
		String requete = "UPDATE client SET credit = ? WHERE nom = ?";
		try(Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacie", "root", "");
				PreparedStatement preparedStatement = connexion.prepareStatement(requete)){

			preparedStatement.setDouble(1, client.getCredit());
			preparedStatement.setString(2, client.getNom());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			System.out.println("boulette maj medoc en bdd !");
			System.out.println(e.getMessage());
		}
	}



	public Client lireClient(String nom) throws Exception {
		boolean trouve = false;
		Client c = null;
		List<Client> clients = this.getClients();
			for (int i = 0; (i < clients.size()); i++) {
				if ((clients.get(i).getNom()).equals(nom)) {
					trouve = true;
					c = clients.get(i);
					return c;
				}
			}
			if (!trouve) {
				System.out.println("Client inconnu. Veuilliez recommencer");
			}
		throw new Exception("Client inconnu. Veuilliez recommencer");
	}


	public Medicament lireMedicament(String nom) throws Exception {
		boolean trouve=false;
		Medicament m = null;
		List<Medicament> medocs = this.getMedicaments();
		for (int i = 0; (i < medocs.size()); i++) {
			if ((medocs.get(i).getNom()).equals(nom)) {
				trouve = true;
				m = medocs.get(i);
				return m;
			}
		}
		if (!trouve) {
			System.out.println("Médicament inconnu. Veuilliez recommencer");
		}
		throw new Exception("Médicament inconnu");
	}


	public void creationBDDClient(Client client) {

		String requete = "INSERT into client(nom, credit) values(?,?)";

		try(Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacie", "root", "");
				PreparedStatement preparedStatement = connexion.prepareStatement(requete)){

			preparedStatement.setString(1, client.getNom());
			preparedStatement.setDouble(2, client.getCredit());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			System.out.println("boulette ajout client en bdd !");
		}
	}
	
	public void creationBDDMed(Medicament medicament) {

		String requete = "INSERT into medicament(nom, prix, stock) values(?,?,?)";

		try(Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacie", "root", "");
				PreparedStatement preparedStatement = connexion.prepareStatement(requete)){

			preparedStatement.setString(1, medicament.getNom());
			preparedStatement.setDouble(2, medicament.getPrix());
			preparedStatement.setInt(3, medicament.getStock());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			System.out.println("boulette ajout medicament en bdd !");
		}
	}




}

