package com.application.shopping.service.admin;

import com.application.shopping.dao.admin.ProductDao;
import com.application.shopping.entity.admin.ImageModel;
import com.application.shopping.entity.admin.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDao productDao;
    @Override
    public Product createProduct(Product product, MultipartFile[] files) {
        try{
            Set<ImageModel> productImages = uploadImages(files);
            product.setProductImages(productImages);
            productDao.save(product);

        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productDao.save(product);
    }

    @Override
    public List<Product> getAllProducts(Integer pageNumber, String searchKey) {
        Pageable pageable = PageRequest.of(pageNumber, 2);

        if(searchKey.equals("")) {
            return productDao.findAll(pageable);
        } else {
            return productDao.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase (
                    searchKey, searchKey, pageable);
        }
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteById(productId);
    }


    private Set<ImageModel> uploadImages(MultipartFile[] files) throws Exception {
        Set<ImageModel> productImages = new HashSet<>();

        for(MultipartFile file:files) {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );

            productImages.add(imageModel);
        }

        return productImages;
    }
}
