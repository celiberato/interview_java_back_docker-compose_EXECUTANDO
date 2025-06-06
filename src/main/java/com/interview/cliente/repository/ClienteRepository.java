package com.interview.cliente.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Optional<Cliente> findById(Long id);

	Cliente findByNome(String nome);

    List<Cliente> findAll();
  

}

