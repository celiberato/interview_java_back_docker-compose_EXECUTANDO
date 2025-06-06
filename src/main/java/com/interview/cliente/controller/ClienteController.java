package com.interview.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.cliente.model.request.ClienteRequest;
import com.interview.cliente.model.response.ClienteResponse;
import com.interview.cliente.repository.ClienteRepository;
import com.interview.cliente.usecase.CriarClienteUseCase;
import com.interview.cliente.utils.mapper.ClienteMapper;


@RestController
@RequestMapping(value = {"/cliente"})
public class ClienteController {

	ClienteMapper mapper = new ClienteMapper();

	@Autowired
	private CriarClienteUseCase criarCliente;
	
	@Autowired
	private ListarClientesUseCase listarClientes;

	@Autowired
	private ConsultarClientesUseCase consutarCliente;

	@Autowired
	private AtualizarClienteUseCase atualizarClentes;

	@Autowired
	private ApagarClienteUseCase apagarCliente;
	
	@Autowired
	private ClienteRepository repository;

	@PostMapping("criar")
	public ResponseEntity<ClienteResponse> criarCliente(@RequestBody @Validated ClienteRequest clienteRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
				mapper.toClienteResponse(
						criarCliente.save(
								mapper.toCliente(clienteRequest))));
	}

	@GetMapping("/todos")
	public ResponseEntity<List<ClienteResponse>> listarTodosClientes() {
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toListaResponse(
						listarClientes.listarTodosClientes()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponse> getById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toClienteResponse(consultarCliente.obteobterClientePorId(id))
		);
	}

	@PutMapping("{id}")
	public ResponseEntity<ClienteResponse> atualizarCliente(@RequestBody @Validated ClienteRequest clienteRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toClienteResponse(
					atualiarCliente.salvar(mapper.toCliente(clienteRequest)))
		);
	}

	@DeleteMapping("/{id}")
	public void apagarCliente(@PathVariable Long id) {
		apagarCliente.apagar(id);
	}

}
