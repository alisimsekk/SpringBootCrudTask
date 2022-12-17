package com.task.springbootcrudtask.controller;

import com.task.springbootcrudtask.model.Product;
import com.task.springbootcrudtask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> addProduct (@RequestBody Product product){
        return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById (@PathVariable ("id") int id){
        String result = productService.deleteProductById(id);
        return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
    }

//getall
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct (){
        List<Product> productList = productService.findAllProduct();
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody Product product){
        return new ResponseEntity<Product>(productService.update(id,product), HttpStatus.OK);
    }

    //get
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
    }
}
