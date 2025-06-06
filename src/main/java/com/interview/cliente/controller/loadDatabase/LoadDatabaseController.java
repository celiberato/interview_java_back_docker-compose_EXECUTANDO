package com.interview.cliente.controller.loadDatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.cliente.model.response.ClienteResponse;
import com.interview.cliente.repository.ClienteRepository;
import com.interview.cliente.usecase.ClienteService;
import com.interview.cliente.utils.mapper.ClienteMapper;
import com.interview.entity.Cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = {"/load"})
@Tag(name = "Produtos", description = "Operações relacionadas a produtos")
public class LoadDatabaseController {

	ClienteMapper mapper = new ClienteMapper();

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ClienteService service;

	@GetMapping("/all")
	@Operation(summary = "Busca um produto pelo ID", description = "Retorna um produto específico pelo ID")
	public ResponseEntity<List<ClienteResponse>> loadData() {
		repository.save(new Cliente(null, "JOSÉ"));
		repository.save(new Cliente(null, "MARELO"));
		repository.save(new Cliente(null, "RICARDO"));
		repository.save(new Cliente(null, "DANIEL"));
		repository.save(new Cliente(null, "RFAEL"));
		
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toListaResponse(
						service.listarTodosClientes()));

	}

}
