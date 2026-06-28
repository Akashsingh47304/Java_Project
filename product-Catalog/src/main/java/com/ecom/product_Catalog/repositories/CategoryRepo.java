package com.ecom.product_Catalog.repositories;

import com.ecom.product_Catalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo  extends JpaRepository<Category,Long> {
}
