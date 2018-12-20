package com.fassine.service;

import org.springframework.stereotype.Component;

import com.fassine.entity.Banco1Details;
import com.fassine.entity.Banco2Details;

@Component
public interface BancoService {
	
	Banco1Details insereBanco1();
	Banco2Details insereBanco2();
}
