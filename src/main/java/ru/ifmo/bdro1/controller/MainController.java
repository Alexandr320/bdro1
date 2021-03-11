package ru.ifmo.bdro1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "mainPage";
    }

    @GetMapping("/pageToAuthorization")
    public String authorizationPage() {
        return "pageToAuthorization";
    }
}
