package com.acme.tukibackend.repository.discount;

import com.acme.tukibackend.model.discount.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
