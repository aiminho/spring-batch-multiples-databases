package com.fassine.database2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fassine.entity.Banco2Details;

@Repository
public interface Banco2Repository extends JpaRepository<Banco2Details, Long> {
	
	Banco2Details findByValorBanco2(String valor);

}
