package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepository extends JpaRepository<ProductsEntity,Long> {

    @Query(value = "select p from ProductsEntity p where p.name LIKE %:keyword% "
            + " or p.detail LIKE %:keyword% "
            + " or p.title LIKE %:keyword%")
    List<ProductsEntity> search(@Param("keyword") String keyword);

    @Query(value = "select p from ProductsEntity p order by p.name desc")
    List<ProductsEntity> sortProduct();

    @Query(value = "select p from ProductsEntity p order by p.price desc")
    List<ProductsEntity> sortPriceDesc();

    @Query(value = "select p from ProductsEntity p order by p.price asc")
    List<ProductsEntity> sortPriceAsc();
}
