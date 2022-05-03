package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductsEntity;
import com.laptrinhjavaweb.repository.SearchRepository;
import com.laptrinhjavaweb.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService implements ISearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public List<ProductDTO> search(String keyword) {
        List<ProductDTO> model = new ArrayList<>();
        List<ProductsEntity> entities = searchRepository.search(keyword);
        for (ProductsEntity item : entities){
            ProductDTO dto = productConverter.toDto(item);
            model.add(dto);
        }
        return model;
    }

    @Override
    public List<ProductDTO> sortPro() {
        List<ProductDTO> model = new ArrayList<>();
        List<ProductsEntity> entities = searchRepository.sortProduct();
        for (ProductsEntity item : entities){
            ProductDTO productDTO = productConverter.toDto(item);
            model.add(productDTO);
        }
        return model;
    }

    @Override
    public List<ProductDTO> sortPriceDesc() {
        List<ProductDTO> model = new ArrayList<>();
        List<ProductsEntity> entities = searchRepository.sortPriceDesc();
        for (ProductsEntity item : entities){
            ProductDTO productDTO = productConverter.toDto(item);
            model.add(productDTO);
        }
        return model;
    }

    @Override
    public List<ProductDTO> sortPriceAsc() {
        List<ProductDTO> model = new ArrayList<>();
        List<ProductsEntity> entities = searchRepository.sortPriceAsc();
        for (ProductsEntity item : entities){
            ProductDTO productDTO = productConverter.toDto(item);
            model.add(productDTO);
        }
        return model;
    }

}
