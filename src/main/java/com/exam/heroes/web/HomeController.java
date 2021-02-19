package com.exam.heroes.web;

import com.exam.heroes.model.service.HeroServiceModel;
import com.exam.heroes.model.service.UserServiceModel;
import com.exam.heroes.model.view.HeroViewModel;
import com.exam.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final HeroService heroService;
    private final ModelMapper modelMapper;

    public HomeController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
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

        model.addAttribute("username",
                ((UserServiceModel) httpSession.getAttribute("user")).getUsername());
        List<HeroViewModel> heroes = this.heroService.getAll().stream()
                .map(h -> this.modelMapper.map(h, HeroViewModel.class))
                .collect(Collectors.toUnmodifiableList());

        model.addAttribute("heroes", heroes);

        return "home";
    }
}
