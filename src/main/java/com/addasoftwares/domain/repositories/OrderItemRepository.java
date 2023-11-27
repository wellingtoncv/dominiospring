package com.addasoftwares.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addasoftwares.domain.entities.OrderItem;

/*
	Para efetuar acesso a dadso no banco atraves da interface Repository, neste caso o ClientRepository para acessar os dados de Client;
	Precisa extendar a interface JPARepository;

*/

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
