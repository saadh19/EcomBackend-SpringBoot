package com.example.EcomBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.EcomBackend.model.Product;
import com.example.EcomBackend.service.ProductService;
import com.sun.net.httpserver.HttpServer;


@RestController
@RequestMapping("/api")

public class ProductController {

    
    private ProductService service;
    
     @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }
    
    

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = service.getProducts();
        if(products!=null)
            return new ResponseEntity<>( products, HttpStatus.OK);
        else 
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product!=null)
            return new ResponseEntity<>( product, HttpStatus.OK);
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
            Product saved_product = service.addProduct(product, imageFile);
            return new ResponseEntity<>(saved_product, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }    
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile){
        try{
            Product product1 = service.updateProduct(id, product, imageFile);
            if(product1!=null)
                return new ResponseEntity<>("Updated", HttpStatus.OK);
            else 
                return new ResponseEntity<>("Product not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product!=null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Delated Product", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No product avaiable", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam  String keyword){
        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
