package com.application.shopping.controller.admin;

import com.application.shopping.entity.admin.Product;
import com.application.shopping.service.admin.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
@PreAuthorize("hasRole('Admin')")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = {"/add"}, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product addProduct(@RequestPart(name = "product") Product product,
                              @RequestPart(name = "images") MultipartFile[] files) {

        return productService.createProduct(product, files);
    }

    @GetMapping(value = {"/getAll"})
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber,
                                    @RequestParam(defaultValue = "") String searchKey) {
       return productService.getAllProducts(pageNumber, searchKey);
    }

    @DeleteMapping(value = {"/delete/{productId}"})
    public void deleteProduct(@PathVariable(name = "productId") Integer productId) {
        productService.deleteProduct(productId);

    }

}
