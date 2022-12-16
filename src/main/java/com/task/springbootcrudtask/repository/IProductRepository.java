package com.task.springbootcrudtask.repository;

import com.task.springbootcrudtask.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategoryId (int categoryId);
}
