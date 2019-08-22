package com.es.eoi.rest.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.es.eoi.rest.entities.Cuenta;

public class AccountRepositoryImpl implements MyRepository<Cuenta> {

	@SuppressWarnings("unused")
	private EntityManagerFactory emf;
	private EntityManager em;

	public AccountRepositoryImpl() {

		this.emf = Persistence.createEntityManagerFactory("EJERCICIOPU");
		this.em = emf.createEntityManager();
	}

	public boolean create(Cuenta c) {

		try {

			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			return false;
		}

	}

	public Cuenta read(Cuenta c) {

		try {

			return em.find(c.getClass(), c.getIdCuenta());

		} catch (Exception e) {
			return null;
		}

	}

	public Cuenta readByID(int id) {
		@SuppressWarnings("unused")
		Cuenta tcuenta = null;

		try {

			return (tcuenta = em.find(Cuenta.class, id));

		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cuenta> readAll() {

		try {
			String hql = "from Cuenta";
			Query query = em.createQuery(hql);
			List<Cuenta> result = null;
			result = query.getResultList();

			return result;

		} catch (Exception e) {
			return null;
		}

	}

	public boolean update(Cuenta c) {
		try {

			em.getTransaction().begin();
			em.merge(c);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			return false;
		}
	}

	public boolean delete(Cuenta c) {

		Cuenta ct = null;

		try {

			ct = em.find(Cuenta.class, c);
			em.getTransaction().begin();
			em.remove(ct);
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {

			em.getTransaction().rollback();
			return false;
		}
	}

}
