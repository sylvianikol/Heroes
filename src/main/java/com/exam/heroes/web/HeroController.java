package com.exam.heroes.web;

import com.exam.heroes.model.binding.HeroCreateBindingModel;
import com.exam.heroes.model.service.HeroServiceModel;
import com.exam.heroes.model.view.HeroViewModel;
import com.exam.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/heroes")
public class HeroController {

    private final HeroService heroService;
    private final ModelMapper modelMapper;

    @Autowired
    public HeroController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create")
    public String create(Model model, HttpSession httpSession) {
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        if (!model.containsAttribute("heroCreateBindingModel")) {
            model.addAttribute("heroCreateBindingModel", new HeroCreateBindingModel());
            model.addAttribute("exists", false);
        }

        return "create-hero";
    }

    @PostMapping("/create")
    public String createConfirm(@Valid HeroCreateBindingModel heroCreateBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("heroCreateBindingModel", heroCreateBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.heroCreateBindingModel",
                    bindingResult);

            return "redirect:create";
        }

        boolean isAdded = this.heroService.add(
                this.modelMapper.map(heroCreateBindingModel, HeroServiceModel.class));

        if (!isAdded) {
            redirectAttributes.addFlashAttribute("heroCreateBindingModel", heroCreateBindingModel);
            redirectAttributes.addFlashAttribute("exists", true);

            return "redirect:create";
        }

        return "redirect:/home";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable String id,
                          Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        HeroViewModel hero = this.modelMapper.map(this.heroService.getById(id), HeroViewModel.class);
        model.addAttribute("hero", hero);

        return "details-hero";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id,
                         Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        HeroViewModel hero = this.modelMapper.map(this.heroService.getById(id), HeroViewModel.class);
        model.addAttribute("hero", hero);

        return "delete-hero";
    }

    @PostMapping("/delete/{id}")
    public String deleteConfirm(@PathVariable String id) {
        this.heroService.deleteById(id);
        return "redirect:/home";
    }
}
