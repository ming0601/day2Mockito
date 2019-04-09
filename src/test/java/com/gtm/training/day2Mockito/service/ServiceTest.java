package com.gtm.training.day2Mockito.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
		
		service.setDao(dao);
	}
	
	@Test
	public void testInsert() {
		
		
		Client client = new Client("Roger", "000015");
		
		when(dao.save(client)).thenReturn(client);
		
		Client result = service.saveClient(client);
		
		Assert.assertEquals(client, result);
		
	}
}
