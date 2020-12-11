package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LandingController {

    @RequestMapping("/")
    public String body(){
        return "redirect:/admin/books/all";
    }
}
