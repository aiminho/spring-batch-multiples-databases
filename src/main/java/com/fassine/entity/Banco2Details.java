package com.fassine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banco2Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBanco2;	
	private String valorBanco2;
	
	public Banco2Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banco2Details(Long idBanco2, String valorBanco2) {
		super();
		this.idBanco2 = idBanco2;
		this.valorBanco2 = valorBanco2;
	}

	public Long getIdBanco2() {
		return idBanco2;
	}

	public void setIdBanco2(Long idBanco2) {
		this.idBanco2 = idBanco2;
	}

	public String getValorBanco2() {
		return valorBanco2;
	}

	public void setValorBanco2(String valorBanco2) {
		this.valorBanco2 = valorBanco2;
	}
}
