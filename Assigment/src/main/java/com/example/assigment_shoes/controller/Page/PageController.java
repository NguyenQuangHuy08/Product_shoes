package com.example.assigment_shoes.controller.Page;

import com.example.assigment_shoes.entity.Product;
import com.example.assigment_shoes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/lists")
    public String productPage(Model model,
                              @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "3") Integer pageSize
    ) {

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Product> page = productRepository.findAll(pageable);

        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("lists", page.getContent());
        return "page/lists";
    }

    @GetMapping("/details/{id}")
    public String detailPage(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "product/details";
    }

}
