package xyz.rushd.validation.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.rushd.validation.model.Product;
import xyz.rushd.validation.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/add-product")
  public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
    Product saved =  productService.addProduct(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }

  @GetMapping("/all-products")
  public ResponseEntity<List<Product>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }
}
