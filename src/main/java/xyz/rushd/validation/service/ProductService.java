package xyz.rushd.validation.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import xyz.rushd.validation.model.Product;

@Service
public class ProductService {
  private final List<Product> products =  new ArrayList<>();
  private long nextId = 1;

  public Product addProduct(Product product) {
    product.setId(nextId++);
    products.add(product);
    return product;
  }

  public List<Product> getAllProducts() {
    return products;
  }
}
