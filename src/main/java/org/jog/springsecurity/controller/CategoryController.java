package org.jog.springsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.jog.springsecurity.dto.CategoryDTO;
import org.jog.springsecurity.persistence.entity.Category;
import org.jog.springsecurity.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> findAll(Pageable pageable) {

        Page<Category> categoryPage = categoryService.findAll(pageable);

        return categoryPage.hasContent() ?
                ResponseEntity.ok(categoryPage) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> findById(@PathVariable Long categoryId) {

        return categoryService.findById(categoryId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createOne(categoryDTO));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> update(@PathVariable Long categoryId,
                                           @RequestBody CategoryDTO categoryDTO) {

        return ResponseEntity.ok(categoryService.updateOne(categoryDTO, categoryId));

    }

    @PutMapping("/{categoryId}/disabled")
    public ResponseEntity<Category> disable(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryService.disableOne(categoryId));
    }
}
