package com.samarth_dev.repository;

import com.samarth_dev.modal.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByCategoryId(String categoryId);
}
