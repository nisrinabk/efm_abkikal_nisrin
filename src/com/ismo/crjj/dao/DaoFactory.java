package com.ismo.crjj.dao;

import com.ismo.crjj.dao.DaoRue;
import com.ismo.crjj.dao.DaoAppartement;
import com.ismo.crjj.dao.DaoEtage;
import com.ismo.crjj.dao.DaoImmeuble;
import com.ismo.crjj.dao.IDao;
import com.ismo.crjj.dao.TypeDao;

public class DaoFactory {
	public static IDao getDAO(TypeDao type) {
		switch (type) {
			case Rue: return new DaoRue();
			case Immeuble: return new DaoImmeuble();
			case Etage: return new DaoEtage();
			case Appartement: return new DaoAppartement();
			
		}
		return null;
	}
}
