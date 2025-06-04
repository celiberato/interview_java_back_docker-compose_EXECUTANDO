package com.lmt.fabricanteback.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmt.fabricanteback.product.model.ProductVO;
import com.lmt.fabricanteback.product.service.ProductService;
import com.lmt.fabricanteback.repository.ProductRepository;


@RestController
@RequestMapping(value = {"/product"})
public class ProductController {

	ProductMapper mapper = new ProductMapper();

	@Autowired
	private ProductService service;
	@Autowired
	private ProductRepository repository;

	@PostMapping
	public ResponseEntity<ProductVO> createProduct(@RequestBody @Validated ProductDTO productDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(
				mapper.toVO(
						repository.save(
								mapper.toEntity(productDTO))));
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProductVO>> listAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toVOList(
						service.listAll()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductVO> getById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(
				mapper.toVO(service.getByProductId(id))
		);
	}
//
//	@PutMapping
//	public ResponseEntity<ProductVO> updateProduct(@RequestBody @Validated ProductDTO productDTO) {
//		return ResponseEntity.status(HttpStatus.OK).body(
//				mapper.toVO(
//					service.save(mapper.toEntity(productDTO)))
//		);
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteProduct(@PathVariable Long id) {
//		service.delete(id);
//	}

}
