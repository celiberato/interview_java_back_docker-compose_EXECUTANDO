package com.interview.cliente.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.cliente.model.request.ClienteRequest;
import com.interview.cliente.model.response.ClienteResponse;
import com.interview.cliente.repository.ClienteRepository;
import com.interview.entity.Cliente;
import com.interview.enumeration.StatusEnum;

public class CriarClienteUseCase {
	
	@Autowired
	private ClienteRepository repository;


    public CriarClienteUseCase(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteResponse execute(ClienteRequest request) {
        Cliente cliente = new Cliente(request.getNome(), request.getEmail());
        
        cliente.setStatus(StatusEnum.CRIADO);
        
        repository.save(cliente);
        
        return new ClienteResponse(
        		cliente.getId(), 
        		cliente.getNome(),
        		cliente.getEmail());
    }
}