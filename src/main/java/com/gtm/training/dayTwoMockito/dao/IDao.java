package com.gtm.training.dayTwoMockito.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gtm.training.dayTwoMockito.model.Client;

@Transactional
@Repository
public interface IDao extends JpaRepository<Client, Integer>{

	public Client getByName(String name);
	public void deleteByName(String name);
	
}
