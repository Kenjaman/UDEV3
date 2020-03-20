package udev3.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public void creationBDDClient(Client client) {

		String requete = "INSERT into client(nom, credit) values(?,?)";

		try(Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pharmacie", "root", "");
				PreparedStatement preparedStatement = connexion.prepareStatement(requete)){

			preparedStatement.setString(1, client.getNom());
			preparedStatement.setDouble(2, client.getCredit());
			preparedStatement.executeUpdate();
		}catch(Exception e) {
			System.out.println("boulette ajout en bdd !");
		}
	}
	
	
	
	
}

