package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Garage;

public class GarageHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarGarage");
	
	public void insertGarage(Garage s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Garage> showAllGarages(){
		EntityManager em = emfactory.createEntityManager();
		List<Garage> allGarages = em.createQuery("SELECT g FROM Garage g").getResultList();
		return allGarages;
	}
}
