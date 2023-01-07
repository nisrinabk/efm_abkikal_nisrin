package com.ismo.crjj.daoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ismo.crjj.dao.*;
import com.entities.*;

class DaoAppartementTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void getAlltest() {
		IDao dao = DaoFactory.getDAO(TypeDao.Appartement);
		List<Appartement> appartements = dao.getAll();
		
		assertNotNull(appartements);
		assertEquals(appartements.size(), 4);
	}
	
	@Test
	void getOnetest_1() {
		IDao dao = DaoFactory.getDAO(TypeDao.Appartement);
		Appartement app = (Appartement) dao.getOne(3);

		assertEquals(app.getId(), "app");
		assertEquals(app.getNbPiece(), 10);
		
		
	}
	
	@Test
	void getOnetest_2() {
		IDao dao = DaoFactory.getDAO(TypeDao.Appartement);
		Appartement appartement = (Appartement) dao.getOne(2);

		assertNull(appartement);
	}
	
	@Test
	void savetest() {
		IDao dao = DaoFactory.getDAO(TypeDao.Appartement);
		List<Appartement> apps_before = dao.getAll();
		Appartement e = new Appartement( "app",20);
		dao.save(e);
		List<Appartement> apps_after = dao.getAll();
		assertEquals(apps_before.size()+1, apps_after.size());
	}

}

