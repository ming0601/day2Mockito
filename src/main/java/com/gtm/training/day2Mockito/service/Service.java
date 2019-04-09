package com.gtm.training.day2Mockito.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gtm.training.day2Mockito.dao.IDao;
import com.gtm.training.day2Mockito.model.Client;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	IDao dao;
	
	public Client saveClient(Client client) {
		
		return this.dao.save(client);
	}
	
	public Client getByName(String name) {
		
		return this.dao.getByName(name);
	}
}
