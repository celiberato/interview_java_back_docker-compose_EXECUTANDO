package com.lmt.fabricanteback.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.lmt.fabricanteback.product.entity.Product;
import com.lmt.fabricanteback.product.model.ProductVO;


public class ProductMapper {

	static ModelMapper modelMapper = new ModelMapper();
	
	
    Product toEntity(ProductDTO dto){
    	return modelMapper.map(dto, Product.class);
    };

    ProductVO toVO(Product produto) {
    	return modelMapper.map(produto, ProductVO.class);
	}
    
    
    public List<ProductVO> toVOList(List<Product> produtos) {
    	List<ProductVO> listaVO = new ArrayList<>();
    	for (Product product : produtos) {
    		
			listaVO.add(
					modelMapper.map(product, ProductVO.class));
		} 
    	
        return listaVO;
    }

    public List<Product> toEntityList(List<ProductDTO> listaDTO) {
    	List<Product> listaEntity = new ArrayList<>();
    	for (ProductDTO product : listaDTO) {
    		
    		listaEntity.add(
					modelMapper.map(product, Product.class));
		} 
    	
        return listaEntity;
    }
}

