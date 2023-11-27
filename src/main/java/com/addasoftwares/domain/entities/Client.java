package com.addasoftwares.domain.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Mapear a classe cliente a tabelas de dados - Este é o mapeamento do objeto relacional da classe com o banco de dados;

@Entity
@Table(name = "tb_client")

//Previnir problemas de tráfico de redes;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Definição do Id como chave primária autoinclemento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	
	//Construtor sem argumentos para que o framwork o estancie;
	
	public Client() {
	}

	//Construtor com argumentos para a chamada para estanciar argumentos;
	
	public Client(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	//Gets e Sets para atribuir valores;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
