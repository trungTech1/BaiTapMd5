package com.example.baitap3.controller;

import com.example.baitap3.model.Accounts;
import com.example.baitap3.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class AccountController {

    @Autowired
    private IAccountService customerService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("account", customerService.findAll());
        return "account";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("account", new Accounts());
        return "addAccount";
    }

    @PostMapping("/add")
    public String handleAdd(@ModelAttribute("account") Accounts accounts) {
        customerService.save(accounts);
        return "redirect:/";
    }

    @GetMapping("/edit/{idEdit}")
    public String viewEdit(@PathVariable Integer idEdit, Model model) {
        model.addAttribute("account", customerService.findById(idEdit));
        return "editAccount";
    }

    @PostMapping("/edit")
    public String handleEdit(@ModelAttribute("customer") Accounts accounts) {
        customerService.save(accounts);
        return "redirect:/";
    }

    @GetMapping("/delete/{idDelete}")
    public String handleDelete(@PathVariable Integer idDelete) {
        customerService.delete(idDelete);
        return "redirect:/";
    }

}
