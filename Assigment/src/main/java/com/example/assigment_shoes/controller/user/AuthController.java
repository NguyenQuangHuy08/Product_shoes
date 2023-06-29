package com.example.assigment_shoes.controller.user;

//Authentication : Xác thực
//Authorization : phân quyền

import com.example.assigment_shoes.entity.Users;
import com.example.assigment_shoes.repository.user.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model){

        model.addAttribute("user",new Users());
        return "login";

    }

    @PostMapping("/login")
    public String checkLogin(

            @Valid @ModelAttribute("user") Users user,
            BindingResult result, HttpSession session,
            Model model

            ){

        //validation

        if(result.hasErrors()){

              return "login";

        }

        Users userFromDB = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());

        if(userFromDB !=null){

            session.setAttribute("userLogged",userFromDB);
            return "redirect:/home";

        }

        //login failed

        model.addAttribute("message", "UserName or Password incorrect ");
        return "login";

    }


    @GetMapping("logout")
    public String logout(Model model, Users users ,  HttpSession session ) {
        session.removeAttribute(users.getUsername());
        model.addAttribute("user", new Users());
        return "login";
    }

//    Todo

    @GetMapping("/add")
    public String createLogin(Model model){

        model.addAttribute("user", new Users());
        return "enregistrer";

    }

    @PostMapping("/add")
    public String saveProduct(
                              @Valid @ModelAttribute("user") Users user,
                              BindingResult result,
                              RedirectAttributes attributes
                            ){

        if(result.hasErrors()){

            return "enregistrer";

        }
        userRepository.save(user);
        attributes.addFlashAttribute("message","Create new product was successfully");
        return "redirect:/login";

    }


    //Todo code 404

    @GetMapping("/404")
    public String loi404(){

        return "template/er404";

    }

    //Todo code 403

    @GetMapping("/403")
    public String loi403(){

        return "template/er403";

    }

}
