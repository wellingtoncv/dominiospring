package com.addasoftwares.domain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.addasoftwares.domain.entities.Order;
import com.addasoftwares.domain.repositories.OrderRepository;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderRepository repository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		try {
			Order obj = repository.findById(id).get();
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registos não encontrado!", e);
		}
	}

	@GetMapping(value = "/all")
	public List<Order> findAll() {
		try {
			List<Order> result = repository.findAll();
			return result;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registos não encontrado!", e);
		}
	}
}
