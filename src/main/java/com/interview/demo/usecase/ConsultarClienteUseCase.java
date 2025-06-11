package com.interview.demo.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.demo.entity.Cliente;
import com.interview.demo.repository.ClienteRepository;

public class ConsultarClienteUseCase {

	@Autowired
	private ClienteRepository repository;

	public Cliente execute(Long id) {
		return repository.findById(id).get();
	}

}
