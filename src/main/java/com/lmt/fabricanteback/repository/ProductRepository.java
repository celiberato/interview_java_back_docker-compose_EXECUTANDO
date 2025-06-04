package com.lmt.fabricanteback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmt.fabricanteback.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<Product> findById(Long id);

	Product findByNome(String nome);

    List<Product> findAll();
  

}

