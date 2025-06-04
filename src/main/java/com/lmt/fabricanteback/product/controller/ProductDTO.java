package com.lmt.fabricanteback.product.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDTO {

	private Long id;

	@NotNull(message = "Nome do produto não pode estar nulo!")
	@NotBlank(message = "Nome do produto não pode estar em branco!")
	private String nome;

	
	public ProductDTO() {
		super();
	}	

	public ProductDTO(Long id,
			@NotEmpty(message = "Nome do produto não pode estar nulo!") String name){
		super();
		this.id = id;
		this.nome = nome;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
