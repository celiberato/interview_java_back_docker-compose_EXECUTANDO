package com.lmt.fabricanteback.product.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmt.fabricanteback.product.entity.Product;
import com.lmt.fabricanteback.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private ProductRepository repository;

	public Product save(Product product) {
		if (product.getNome().isEmpty()) {
			throw new IllegalArgumentException("[X]-> Produto está null ou vazio!");
		}

		return repository.save(product);
	}

	@Transactional
	public List<Product> listAll() {
		
		return repository.findAll();

	}

	public Product getByProductId(Long id) {
		return repository.findById(id).get();
	}
//
//	@Transactional
//	public ProductVO update(ProductVO product) {
//		if (product.toString().isEmpty()) {
//			throw new IllegalArgumentException("[X]-> Produto está null ou vazio!");
//		}
//
//		return modelMapper.map(
//				repository.findById(product.getId()).get(), ProductVO.class));
//	
//	}
//
//	public void delete(Long id) {
//		if (id==null) {
//			throw new IllegalArgumentException("[X]-> Produto está null ou vazio!");
//		}
//
//		repository.deleteById(id);
//	}

}
