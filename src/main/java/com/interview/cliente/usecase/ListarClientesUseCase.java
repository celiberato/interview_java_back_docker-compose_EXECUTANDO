package com.interview.cliente.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.cliente.repository.ClienteRepository;
import com.interview.entity.Cliente;

import jakarta.transaction.Transactional;

public class ListarClientesUseCase {

	@Autowired
	private ClienteRepository repository;

	@Transactional
	public List<Cliente> execute() {	
		return repository.findAll();

	}

}
