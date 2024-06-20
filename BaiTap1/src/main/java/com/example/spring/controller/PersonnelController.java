package com.example.spring.controller;

import com.example.spring.model.Personnel;
import com.example.spring.service.IPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    private IPersonnelService personnelService;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/personnel")
    public String personnel(Model model) {
        model.addAttribute("personnel", personnelService.findAll());
        return "personnel/personnel";
    }
    @GetMapping("/add")
    public String add(Model model) {
        System.out.println("add");
        model.addAttribute("personnel", new Personnel());
        return "personnel/add-personnel";
    }
    @PostMapping("/add")
    public String add(Personnel personnel) {
        personnelService.save(personnel);
        return "redirect:/personnel/personnel";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id,Model model) {
        model.addAttribute("personnel", personnelService.findById(id));
        return "personnel/edit-personnel";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute("personnel") Personnel personnel) {
        personnelService.save(personnel);
        return "redirect:/personnel/personnel";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        personnelService.delete(id);
        return "redirect:/personnel/personnel";
    }

}
