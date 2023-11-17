package com.application.shopping.service.admin;

import com.application.shopping.entity.admin.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product, MultipartFile[] files);

    List<Product> getAllProducts(Integer pageNumber, String searchKey);

    void deleteProduct(Integer productId);
}
