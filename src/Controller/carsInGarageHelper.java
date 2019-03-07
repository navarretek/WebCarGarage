package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.carsInGarages;


public class carsInGarageHelper {
static EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("CarGarage");
	
	public void insertCarsInGarage(carsInGarages s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	public List<carsInGarages> getCarsList(){
		EntityManager em = emfactory.createEntityManager();
		List<carsInGarages> allCars = em.createQuery("SELECT d FROM cars_in_garage d").getResultList();
		return allCars;
	}
}
