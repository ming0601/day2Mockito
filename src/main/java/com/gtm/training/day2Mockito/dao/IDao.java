package com.gtm.training.day2Mockito.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gtm.training.day2Mockito.model.Client;

@Repository
public interface IDao extends JpaRepository<Client, Integer>{

	
}
