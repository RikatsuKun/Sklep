package com.jsf.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jsf.entities.Produkt;

//DAO - Data Access Object for Person entity
//Designed to serve as an interface between higher layers of application and data.
//Implemented as stateless Enterprise Java bean - server side code that can be invoked even remotely.

@Stateless
public class ProduktDAO {
	private final static String UNIT_NAME = "jsfcourse-simplePU";

	// Dependency injection (no setter method is needed)
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager em;

	public void create(Produkt produkt) {
		em.persist(produkt);
	}

	public Produkt merge(Produkt produkt) {
		return em.merge(produkt);
	}

	public void remove(Produkt produkt) {
		em.remove(em.merge(produkt));
	}

	public Produkt find(Object id) {
		return em.find(Produkt.class, id);
	}

	public List<Produkt> getFullList() {
		List<Produkt> list = null;

		Query query = em.createQuery("select p from Produkt p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Produkt> getList(Map<String, Object> searchParams) {
		List<Produkt> list = null;

		// 1. Build query string with parameters
		String select = "select p ";
		String from = "from Produkt p ";
		String where = "";
		String orderby = "order by p.id_kategoria asc, p.cena_produktu";

		// search for surname
		String nazwa_produktu = (String) searchParams.get("nazwa_produktu");
		if (nazwa_produktu != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.nazwa_produktu like :nazwa_produktu ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where + orderby);

		// 3. Set configured parameters
		if (nazwa_produktu != null) {
			query.setParameter("nazwa_produktu", nazwa_produktu+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of Person objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
