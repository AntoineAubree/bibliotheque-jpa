package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import fr.diginamic.beans.Client;
import fr.diginamic.beans.Emprunt;
import fr.diginamic.beans.Livre;
import fr.diginamic.utils.ConfigUtils;

public class Application {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque_jpa", ConfigUtils.getPassword());
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Livre livre = em.find(Livre.class, 1);
		System.out.println(livre);
		
		System.out.println("----------------------------------");
		
		Emprunt emprunt = em.find(Emprunt.class, 1);
		System.out.println(emprunt);
		for (Livre livreLoop : emprunt.getLivres()) {
			System.out.println(livreLoop);
		}
		
		System.out.println("----------------------------------");

		Client client = em.find(Client.class, 1);
		System.out.println(client);
		for (Emprunt empruntLoop : client.getEmprunts()) {
			System.out.println(empruntLoop);
		}
		
	}

}
