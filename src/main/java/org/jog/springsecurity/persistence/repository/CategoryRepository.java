package org.jog.springsecurity.persistence.repository;

import org.jog.springsecurity.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
