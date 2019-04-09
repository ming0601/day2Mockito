package com.gtm.training.day2Mockito.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gtm.training.day2Mockito.dao.IDao;
import com.gtm.training.day2Mockito.model.Client;

@org.springframework.stereotype.Service
public class Service {

//	@Autowired
	IDao dao;
	
	public void setDao(IDao dao) {
		
		this.dao = dao;
	}
	
	public Client saveClient(Client client) {
		
		return this.dao.save(client);
	}
}
