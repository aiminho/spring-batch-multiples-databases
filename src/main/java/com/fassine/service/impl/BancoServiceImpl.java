package com.fassine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fassine.database1.repository.Banco1Repository;
import com.fassine.database2.repository.Banco2Repository;
import com.fassine.entity.Banco1Details;
import com.fassine.entity.Banco2Details;
import com.fassine.service.BancoService;

@Service
public class BancoServiceImpl implements BancoService {
	
	@Autowired
	private Banco1Repository banco1Repository;
	@Autowired
	private Banco2Repository banco2Repository;
	
	@Override
	public Banco1Details insereBanco1() {
		Banco2Details b2d = this.banco2Repository.findByValorBanco2("banana banco 2");
		Banco1Details b1 = new Banco1Details();
		b1.setValorBanco1(b2d.getValorBanco2());
		this.banco1Repository.save(b1);
		return b1;
	}
	
	@Override
	public Banco2Details insereBanco2() {
		Banco2Details b2 = new Banco2Details();
		b2.setValorBanco2("banana banco 2");
		//this.banco2Repository.save(b2);
		return b2;
	}
	
}
