package com.fassine.database1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fassine.entity.Banco1Details;

@Repository
public interface Banco1Repository extends JpaRepository<Banco1Details, Long> {
	
	//Banco1Details findByValorBanco1(String valor);
	Banco1Details findByValorBanco1(String valorBanco1);
}
