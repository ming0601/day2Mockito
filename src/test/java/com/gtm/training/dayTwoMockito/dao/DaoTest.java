package com.gtm.training.dayTwoMockito.dao;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gtm.training.dayTwoMockito.dao.IDao;
import com.gtm.training.dayTwoMockito.model.Client;

@SpringBootTest
public class DaoTest {
	
	@Autowired
	private IDao dao;
	
	@BeforeEach
	void init() {
		dao.save(new Client("Jean", "123"));
		dao.save(new Client("Sebastien", "124"));
	}
	
	@AfterEach
	void flush() {
		dao.deleteAll();
	}
		
	@Test
	public void testInsert() {		
		Client client = new Client("Roger", "000015");		
		Client result = dao.save(client);		
		Assertions.assertEquals(client, result);		
	}
	
	@Test
	void testGet() {
		Client result = dao.getByName("Jean");
		Assertions.assertEquals("Jean", result.getName());
		Assertions.assertEquals("123", result.getAccountNumber());
	}
	
	@Test
	void testDelete() {
		dao.deleteByName("Jean");
		Client nullClient = dao.getByName("Jean");
		Assertions.assertNull(nullClient);
	}
	
	@Test
	void getAll() {
		List<Client> clients = dao.findAll();
		Assertions.assertEquals(2, clients.size());
		Assertions.assertEquals("Jean", clients.get(0).getName());
		Assertions.assertEquals("123", clients.get(0).getAccountNumber());
		Assertions.assertEquals("Sebastien", clients.get(1).getName());
		Assertions.assertEquals("124", clients.get(1).getAccountNumber());
	}

}
