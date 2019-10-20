package fr.epsi.udev.ex21;

import java.util.Map.Entry;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class MainExo21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Properties prop = new Properties();
			InputStream monfichierS= new FileInputStream("K:/Code/UDEV3/Java/Exercices/POO/src/fr/epsi/udev/ex21/data.properties");
			prop.load(monfichierS);
			System.out.println(prop.getProperty("fichier.input.personnes", null));
			prop.list(System.out);
			monfichierS.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
