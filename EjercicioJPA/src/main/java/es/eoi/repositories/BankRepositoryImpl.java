package es.eoi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import es.eoi.entities.Banco;

public class BankRepositoryImpl implements MyRepository<Banco> {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJERCICIOPU");
	EntityManager em = emf.createEntityManager();

	public boolean create(Banco b) {

		try {

			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			return false;
		}

	}

	public Banco read(Banco b) {

		try {

			return em.find(b.getClass(), b.getIdBanco());

		} catch (Exception e) {
			return null;
		}

	}

	public Banco readByID(int id) {
		@SuppressWarnings("unused")
		Banco tbanco = null;
		
		try {
			
			return (tbanco = em.find(Banco.class, id));

		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Banco> readAll() {

		try {
			String hql = "from Bancos";
			Query query = em.createQuery(hql);
			List<Banco> result = null;
			result = query.getResultList();

			return result;

		} catch (Exception e) {
			return null;
		}

	}

	public boolean update(Banco b) {
		
		try {

			em.getTransaction().begin();
			em.merge(b);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			return false;
		}
	}

	public boolean delete(Banco b) {
		
		Banco bk = null ;
		
		try {
			
			bk = em.find(Banco.class, b);
			em.getTransaction().begin();
			em.remove(bk);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			return false;
		}
	}

}
