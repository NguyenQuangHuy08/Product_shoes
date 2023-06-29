package com.example.assigment_shoes.controller.category;

import com.example.assigment_shoes.entity.Category;
import com.example.assigment_shoes.repository.CategoryRepository;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ServletContext context;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("create")
    public String showCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @GetMapping("edit/{id}")
    public String showCreateCategory(Model model, @PathVariable Integer id) {
        model.addAttribute("category", categoryRepository.findById(id).orElse(null));
        return "category/edit";
    }

    @GetMapping("/detail/{id}")
    public String detailPage(@PathVariable Integer id, Model model) {

        model.addAttribute("category", categoryRepository.findById(id).orElse(null));
        return "category/detail";

    }

    @PostMapping("create")
    public String saveCategory(Model model,
                               @Valid @ModelAttribute("category") Category category,
                               BindingResult result,
                               RedirectAttributes attributes,
                               @RequestParam("imageCategory") MultipartFile file
    ) {
        if(result.hasErrors()) {

            return "category/create";

        }

        //logic upload file
        String fileOriginal = file.getOriginalFilename();
        String fileDest = context.getRealPath("/upload/" +  fileOriginal);
        System.out.println(fileDest);

        try {
            file.transferTo(new File(fileDest));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        category.setImage(fileOriginal);
        categoryRepository.save(category);

        attributes.addFlashAttribute("message", "Create new categorty was successfully");
        return "redirect:/category/list";

    }

    @GetMapping("list")
    public String showCategoryList(Model model) {

        List<Category> categories = categoryRepository.findAll();
        System.out.println(categories.size());
        model.addAttribute("categories", categories);

        return "category/list";
    }

    //Todo code delete

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){

        if(categoryRepository.existsById(id)){

            categoryRepository.deleteById(id);

        }

        return "redirect:/category/list";

    }





}
