package com.task.springbootcrudtask.controller;

import com.task.springbootcrudtask.model.Category;
import com.task.springbootcrudtask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category addCategory = categoryService.addCategory(category);
        return new ResponseEntity<Category>(addCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoryById (@PathVariable("id") int id){
        String answer = categoryService.deleteCategoryById(id);
        return new ResponseEntity<String>(answer, HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> allCategory = categoryService.findAllCategory();
        return new ResponseEntity<List<Category>>(allCategory, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@PathVariable ("id") int id, @RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.update(id,category), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id){
        Category categoryById = categoryService.getCategoryById(id);
        return new ResponseEntity<Category>(categoryById , HttpStatus.OK);
    }
}
