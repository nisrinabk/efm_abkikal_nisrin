package com.ismo.crjj.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import ma.ismo.crjj.util.*;

import com.entities.*;

public class DaoImmeuble implements IDao<Immeuble>{

	@Override
	public List<Immeuble> getAll() {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		List<Immeuble> Immeubles = session.createQuery("from Immeubles").getResultList();

		t.commit();
		session.close();

		return Immeubles;
	}

	@Override
	public Immeuble getOne(int id) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		Transaction t = session.beginTransaction();

		Immeuble Immeuble = session.get(Immeuble.class, id);

		t.commit();
		session.close();

		return Immeuble;
	}

	@Override
	public boolean save(Immeuble obj) {
		try {
			Session session = HibernateUtil.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			Object o = session.save(obj);

			System.out.println(o);

			t.commit();
			session.close();

			if (o == null)
				return false;
			else
				return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Immeuble obj) {
		try {
			Session session = HibernateUtil.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.update(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Immeuble obj) {
		try {
			Session session = HibernateUtil.getSessionfactory().getCurrentSession();
			Transaction t = session.beginTransaction();

			session.delete(obj);

			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}

