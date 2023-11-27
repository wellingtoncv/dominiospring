package com.addasoftwares.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.addasoftwares.domain.entities.Client;

  /*
	Para efetuar acesso a dadso no banco através da interface Repository, neste caso o ClientRepository para acessar os dados de Client;
   	Precisa extendar a interface JPARepository;

 */

public interface ClientRepository extends JpaRepository<Client, Long> {

}
