package com.gtm.training.day2Mockito.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gtm.training.day2Mockito.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
public class DaoTest {

	
	@Autowired
	private static IDao	dao;
	
//	@BeforeAll
//	public static void initialisation() {
//		
//		dao = new IDao();
//		
//	}
	
	@Test
	public void testInsert() {
		
		Client client = new Client("Roger", "000015");
		
		Client result = dao.save(client);
		
		Assertions.assertEquals(client, result);
		
	}
}
