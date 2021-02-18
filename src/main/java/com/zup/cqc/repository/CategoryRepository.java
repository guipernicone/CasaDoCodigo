package com.zup.cqc.repository;

import com.zup.cqc.entity.category.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
