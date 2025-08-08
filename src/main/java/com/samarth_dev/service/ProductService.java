package com.samarth_dev.service;

import com.samarth_dev.modal.Product;
import com.samarth_dev.modal.Seller;
import com.samarth_dev.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public Product createProduct(CreateProductRequest req, Seller seller);

    public void deleteProduct(Long productId);

    public Product updateProduct(Long productId, Product product);

    Product findProductById(Long productId);

    List<Product> searchProducts();

    public Page<Product> getAllProducts(
            String category,
            String brand,
            String colors,
            String sizes,
            Integer minPrice,
            Integer maxPrice,
            Integer minDiscount,
            String sort,
            String stock,
            Integer pageNumber
    );

    List<Product> getProductBySellerId(Long sellerId);
}
