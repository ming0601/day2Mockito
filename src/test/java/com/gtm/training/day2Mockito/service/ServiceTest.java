package com.gtm.training.day2Mockito.service;

import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gtm.training.day2Mockito.dao.IDao;
import com.gtm.training.day2Mockito.model.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

	@Mock
	private IDao	dao;
	
	@InjectMocks
	@Autowired
	private Service service;

	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testInsert() {
		
		Client client = new Client("Roger", "000015");
		
		when(dao.save(client)).thenReturn(client);
		
		Client result = service.saveClient(client);
		
		Assert.assertEquals(client, result);
	}
	
	@Test
	public void testGet() {
		
		Client client = new Client("Jean", "123");
		
		when(dao.getByName("Jean")).thenReturn(client);
		
		Assert.assertEquals(client, service.getByName("Jean"));
	}
	
	@Test
	public void testDelete() {
		
		doNothing().when(dao).deleteByName("Jean");
		
		service.deleteByName("Jean");
		
		verify(dao, times(1)).deleteByName("Jean");
	}
	
	@Test
	public void getAll() {
		
		List<Client> clients = new ArrayList<>();
		
		clients.add(new Client("Jean", "123"));
		clients.add(new Client("Sebastien", "124"));
		
		when(dao.findAll()).thenReturn(clients);
		
		List<Client> result =service.getAll();
		Assertions.assertEquals(2, result.size());
		Assertions.assertEquals("Jean", result.get(0).getName());
		Assertions.assertEquals("123", result.get(0).getAccountNumber());
		Assertions.assertEquals("Sebastien", result.get(1).getName());
		Assertions.assertEquals("124", result.get(1).getAccountNumber());
	}
}
