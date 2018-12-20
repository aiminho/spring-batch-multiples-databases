package com.fassine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banco1Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBanco1;	
	private String valorBanco1;
	
	public Banco1Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banco1Details(Long idBanco1, String valorBanco1) {
		super();
		this.idBanco1 = idBanco1;
		this.valorBanco1 = valorBanco1;
	}

	public Long getIdBanco1() {
		return idBanco1;
	}

	public void setIdBanco1(Long idBanco1) {
		this.idBanco1 = idBanco1;
	}

	public String getValorBanco1() {
		return valorBanco1;
	}

	public void setValorBanco1(String valorBanco1) {
		this.valorBanco1 = valorBanco1;
	}
	
	
}
