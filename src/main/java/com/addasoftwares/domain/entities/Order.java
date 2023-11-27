package com.addasoftwares.domain.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Mapear a classe cliente a tabelas de dados - Este é o mapeamento do objeto relacional da classe com o banco de dados;

@Entity
@Table(name = "tb_Order")
//Previnir problemas de tráfico de redes;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	private OrderStatus status;

	// Anotação para criar o relacional entre as tabelas e informar qual é o campo
	// cahve para o relacionamento;

	@ManyToOne
	@JoinColumn(name = "Client_id")
	private Client client;

	// Mapear a relação de para muitos;
	@OneToMany(mappedBy = "order")
	private List<OrderItem> items = new ArrayList<>();

	public Order() {

	}

	public Order(Long id, Instant moment, OrderStatus status, Client client) {
		super();
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public double getTotal() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum = sum + item.getSubTotal();

		}
		return sum;
	}

}
