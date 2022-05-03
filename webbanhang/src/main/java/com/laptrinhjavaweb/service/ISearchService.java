package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductsEntity;

import java.util.List;

public interface ISearchService {

    List<ProductDTO> search(String keyword);
    List<ProductDTO> sortPro();
    List<ProductDTO> sortPriceDesc();
    List<ProductDTO> sortPriceAsc();
}
