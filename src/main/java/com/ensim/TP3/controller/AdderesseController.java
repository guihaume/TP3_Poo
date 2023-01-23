package com.ensim.TP3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdderesseController {
    @GetMapping("/addresse")
    public String addresse(@RequestParam(name="nameGET", required=false, defaultValue="1 Rue NoAdress") String
                                   nameGET, Model model) {
        model.addAttribute("nomTemplate", nameGET);
        return "addresse";
    }
}
