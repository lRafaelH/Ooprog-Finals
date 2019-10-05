package com.example.OOPROGL.FINALS.controllers;

import com.example.OOPROGL.FINALS.model.Fruit;
import com.example.OOPROGL.FINALS.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

    @GetMapping("/fruit")
    public String getFruit(Model model) {
        List<Fruit> listfruits = fruitRepository.findAll();
        Fruit fruit = new Fruit();
        model.addAttribute("listFruits", listfruits);
        model.addAttribute("Proper", fruit);
        return "index";
    }

    @GetMapping("/fruit/get")
    public String getPostFruit(Model model) {
        List<Fruit> listfruits = fruitRepository.findAll();
        Fruit fruit = new Fruit();
        model.addAttribute("listFruits", listfruits);
        model.addAttribute("Proper", fruit);
        return "add_fruit";

    }

    @PostMapping("/fruit/add")
    public String addActionButton(@ModelAttribute("listFruits") Fruit newFruit) {
        fruitRepository.save(newFruit);
        return "redirect:/fruit";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView updateFruit(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("update_fruit");
        Fruit fruit = fruitRepository.getOne(id);
        mav.addObject("fruit", fruit);

        return mav;
    }


    @RequestMapping("/delete/{id}")
    public String deleteFruit(@PathVariable(name = "id") long id) {
        fruitRepository.deleteById(id);
        return "redirect:/fruit";
    }
}
