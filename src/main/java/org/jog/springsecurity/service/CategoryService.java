package org.jog.springsecurity.service;

import org.jog.springsecurity.dto.CategoryDTO;
import org.jog.springsecurity.persistence.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(Long categoryId);

    Category createOne(CategoryDTO categoryDTO);

    Category updateOne(CategoryDTO categoryDTO, Long categoryId);

    Category disableOne(Long categoryId);

}
