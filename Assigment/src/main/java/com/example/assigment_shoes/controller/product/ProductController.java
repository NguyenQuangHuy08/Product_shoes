package com.example.assigment_shoes.controller.product;

import com.example.assigment_shoes.entity.Product;
import com.example.assigment_shoes.repository.ProductRepository;
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
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ServletContext context;

    @Autowired
    private ProductRepository productRepository;


//  Todo code detail

    @GetMapping("/detail/{id}")
    public String detailPage(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "product/detail";
    }

//    Todo code create

    @GetMapping("create")
    public String createProduct(Model model){

         model.addAttribute("product", new Product());
         return "product/create";
//         Đường dẫn trả về

    }

    //    Todo code create

    @PostMapping("create")
    public String saveProduct(Model model,
                              @Valid
                              @ModelAttribute("product") Product product,
                              BindingResult result,
                              RedirectAttributes attributes,
                              @RequestParam("imageProduct") MultipartFile file){

        if(result.hasErrors()){

            return "product/create";

        }

        // logic
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

        product.setImage(fileOriginal);
        productRepository.save(product);

        attributes.addFlashAttribute("message","Create new categorty was successfully");
        return "redirect:/product/list";

    }


//    Todo code edit

    @GetMapping("edit/{id}")
    public String showCreateProduct(Model model,
                                    @PathVariable Integer id) {
        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "product/edit";
    }


//     Todo code list

    @GetMapping("list")
    public String showListProduct(Model model){

        List<Product> products = productRepository.findAll();
        System.out.println(products.size());
        model.addAttribute("products", products);

        return "product/list";

    }


//Todo code delete

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){

     if(productRepository.existsById(id)){

         productRepository.deleteById(id);

     }

     return "redirect:/product/list";

    }

//    Lỗi 404  product/403

    @GetMapping("404")
    public String Error403(){

        return "template/404";

    }

}
