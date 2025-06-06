package com.interview.cliente.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.cliente.repository.ClienteRepository;
import com.interview.entity.Cliente;

public class ConsultarClienteUseCase {

	@Autowired
	private ClienteRepository repository;

	public Cliente execute(Long id) {
		return repository.findById(id).get();
	}

}
