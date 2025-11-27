package org.example.interndemo.Services;


import lombok.*;
import org.example.interndemo.Entities.Client;
import org.example.interndemo.Entities.Product;
import org.example.interndemo.Repositories.ClientRepository;
import org.example.interndemo.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private  final ProductRepository productRepository;
    private  final ClientRepository clientRepository;

    public ProductService(ProductRepository productRepository, ClientRepository clientRepository) {
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }

    public Product saveProduct(Product product, Long clientId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
