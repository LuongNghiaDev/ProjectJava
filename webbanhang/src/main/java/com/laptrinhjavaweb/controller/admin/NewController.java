package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.ColorsDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IColorsService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

@Controller
public class NewController extends BaseAdminController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IColorsService colorsService;

    @Autowired
    private MessageUtil messageUtil;


    @RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page,
                                 @RequestParam("limit") int limit, HttpServletRequest request) {
        ProductDTO model = new ProductDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView mav = new ModelAndView("admin/product/listProduct");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(productService.findAllByPagination(pageable));
        model.setTotalItem(productService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/quan-tri/san-pham/chinh-sua", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/product/editProduct");
        ProductDTO model = new ProductDTO();
        if (id != null) {
            model = productService.getProductById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("categories", categoryService.findAllCategory());
        mav.addObject("colors",colorsService.findAllCategory());
        mav.addObject("model", model);
        return mav;
    }

    @PostMapping("/upload")
    public String saveUpload(@ModelAttribute("colors") ColorsDTO colors,
                                  @RequestParam("img") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        colors.setImg(fileName);
        ColorsDTO saveColors = colorsService.save(colors);

        String uploadDir = "/colors" + saveColors.getId();

        Path uploadPath = Paths.get(uploadDir);

        if(Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
        try(InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("colud not save upload "+fileName);
        }

        return "redirect:/quan-tri/san-pham/chinh-sua";
    }
}
