package com.addasoftwares.domain.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//Mapear a classe cliente a tabelas de dados - Este é o mapeamento do objeto relacional da classe com o banco de dados;

@Entity
@Table(name = "tb_product")

//Previnir problemas de tráfico de redes;

public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Definição do Id como chave primária autoinclemento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double prise;
	
	public Product() {
		
	}

	public Product(Long id, String name, Double prise) {
		super();
		this.id = id;
		this.name = name;
		this.prise = prise;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrise() {
		return prise;
	}

	public void setPrise(Double prise) {
		this.prise = prise;
	}
	

}
