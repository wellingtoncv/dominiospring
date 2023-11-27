package com.addasoftwares.domain.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_OrderItem")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantity;
	private Double price;

	// Anotação para criar o relacional entre as tabelas e informar qual é o campo
	// cahve para o relacionamento

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@JsonIgnore // Barrar a serialização do objeto Json na web na hora de buscar um pedido, não vai serializar OroderItem somente Order vai acessar o OrderItem;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderItem() {

	}

	public OrderItem(Long id, Integer quantity, Double price, Product product, Order order) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public double getSubTotal() {
		return quantity * price;
	}

}


