package com.interview.cliente.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.cliente.model.request.ClienteRequest;
import com.interview.cliente.model.response.ClienteResponse;
import com.interview.cliente.repository.ClienteRepository;
import com.interview.entity.Cliente;

import jakarta.transaction.Transactional;

public class AtualizarClienteUseCase {

	@Autowired
	private ClienteRepository repository;


    public AtualizarClienteUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

	@Transactional
    public ClienteResponse execute(ClienteRequest request) {
        Cliente cliente = new Cliente(request.getNome(), request.getEmail());
        
        repository.save(cliente);
        
        return new ClienteResponse(
        		cliente.getId(), 
        		cliente.getNome(), 
        		cliente.getEmail());
    }

}
