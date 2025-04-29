package com.cg.User.Details.controller;

import com.cg.User.Details.model.FormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("formData")
public class FormController {

    @ModelAttribute("formData")
    public FormData formData() {
        return new FormData();
    }

    @GetMapping("/")
    public String showPage1() {
        return "page1";
    }

    @PostMapping("/page1")
    public String processPage1(@ModelAttribute("formData") FormData formData,
                               @RequestParam String firstName,
                               @RequestParam String lastName) {
        formData.setFirstName(firstName);
        formData.setLastName(lastName);
        return "redirect:/page2";
    }

    @GetMapping("/page2")
    public String showPage2(@ModelAttribute("formData") FormData formData, Model model) {
        return "page2";
    }

    @PostMapping("/page2")
    public String processPage2(@ModelAttribute("formData") FormData formData,
                               @RequestParam String email,
                               @RequestParam String phone) {
        formData.setEmail(email);
        formData.setPhone(phone);
        return "redirect:/page3";
    }

    @GetMapping("/page3")
    public String showPage3(@ModelAttribute("formData") FormData formData) {
        return "page3";
    }

    @PostMapping("/page3")
    public String processPage3(@ModelAttribute("formData") FormData formData,
                               @RequestParam String city,
                               @RequestParam String country) {
        formData.setCity(city);
        formData.setCountry(country);
        return "redirect:/page4";
    }

    @GetMapping("/page4")
    public String showSummary(@ModelAttribute("formData") FormData formData) {
        return "page4";
    }
}