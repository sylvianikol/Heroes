package com.exam.heroes.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ModelMapper modelMapper;

    public HomeController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }
        return "home";
    }

    @GetMapping("/home")
    public String home(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:users/login";
        }

        // get all heroes ordered by level  descending
        // model.addAttribute("heroes")

        return "home";
    }
}
