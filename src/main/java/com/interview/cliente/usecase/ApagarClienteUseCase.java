package com.interview.cliente.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.cliente.repository.ClienteRepository;

import jakarta.transaction.Transactional;

public class ApagarClienteUseCase {

	@Autowired
	private ClienteRepository repository;

	@Transactional
	public void execute(Long id) {
		if (id==null) {
			throw new IllegalArgumentException("Para deleção do cliente é necessário informar o ID do cliente!");
		}

		repository.deleteById(id);
	}

}
