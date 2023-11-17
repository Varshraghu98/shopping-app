package com.application.shopping.dao.admin;

import com.application.shopping.entity.admin.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    List<Product> findAll(Pageable pageable);

    List<Product> findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(String searchProductName, String productDescription, Pageable pageable);
}
