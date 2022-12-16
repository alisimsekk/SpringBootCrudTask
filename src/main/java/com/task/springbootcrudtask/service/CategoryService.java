package com.task.springbootcrudtask.service;

import com.task.springbootcrudtask.model.Category;
import com.task.springbootcrudtask.model.Product;
import com.task.springbootcrudtask.repository.ICategoryRepository;
import com.task.springbootcrudtask.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IProductRepository productRepository;

    public Category addCategory (Category category){
        return categoryRepository.save(category);
    }

    public String deleteCategoryById(int categoryId){
        List<Product> productListByCategoryId = productRepository.findAllByCategoryId(categoryId);

        if (!productListByCategoryId.isEmpty()){
            return "This category contains products, can not deleted";
        }
        else{
            categoryRepository.deleteById(categoryId);
            return "Category deleted : " + categoryId;
        }
    }

    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    public Category update(Category category){
        Category updatedCategory = categoryRepository.findById(category.getId()).get();
        updatedCategory.setName(category.getName());
        return categoryRepository.save(updatedCategory);
    }

    public Category getCategoryById (int categoryId){
        return categoryRepository.findById(categoryId).get();
    }

}
