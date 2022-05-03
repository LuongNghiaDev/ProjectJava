package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductsEntity;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SearchController extends BaseController {

    @Autowired
    private ISearchService searchService;

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ModelAndView search(@RequestParam String keyword){
        mav.setViewName("search");
        ProductDTO model = new ProductDTO();
        model.setListResult(searchService.search(keyword));
        mav.addObject("model",model);
        mav.addObject("categoryOfSearch",categoryService.finAll());
        return mav;
    }

    /*@RequestMapping("/sort")
    public ModelAndView sort(){
        mav.setViewName("search");
        ProductDTO model = new ProductDTO();
        model.setListResult(searchService.sortPro());
        mav.addObject("model",model);
        mav.addObject("categoryOfSearch",categoryService.finAll());
        return mav;
    }*/

    @RequestMapping("/sortprice")
    public ModelAndView sortPriceProduct(HttpServletRequest request){
        mav.setViewName("search");
        ProductDTO model = new ProductDTO();
        String nameDesc = request.getParameter("sortDesc");
        String nameAsc = request.getParameter("sortAsc");
        if(nameDesc != null){
            model.setListResult(searchService.sortPriceDesc());
        }else if(nameAsc != null){
            model.setListResult(searchService.sortPriceAsc());
        }
        mav.addObject("model",model);
        mav.addObject("categoryOfSearch",categoryService.finAll());
        return mav;
    }

}
