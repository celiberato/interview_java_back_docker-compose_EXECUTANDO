package com.interview.demo.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.demo.entity.Cliente;
import com.interview.demo.repository.ClienteRepository;

import jakarta.transaction.Transactional;

public class ListarClientesUseCase {

	@Autowired
	private ClienteRepository repository;

	@Transactional
	public List<Cliente> execute() {	
		return repository.findAll();

	}

}
