package com.lmt.fabricanteback.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmt.fabricanteback.product.entity.Product;
import com.lmt.fabricanteback.product.model.ProductVO;
import com.lmt.fabricanteback.product.service.ProductService;
import com.lmt.fabricanteback.repository.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = {"/load"})
@Tag(name = "Produtos", description = "Operações relacionadas a produtos")
public class LoadDatabaseController {

	ProductMapper mapper = new ProductMapper();

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ProductService service;

	@GetMapping("/all")
	@Operation(summary = "Busca um produto pelo ID", description = "Retorna um produto específico pelo ID")
	public ResponseEntity<List<ProductVO>> loadData() {
		repository.save(new Product(null, "JOSÉ"));
		repository.save(new Product(null, "MARELO"));
		repository.save(new Product(null, "RICARDO"));
		repository.save(new Product(null, "DANIEL"));
		repository.save(new Product(null, "RFAEL"));
		
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toVOList(
						service.listAll()));

	}

}
