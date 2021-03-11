package ru.ifmo.bdro1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.bdro1.service.MissileService;
import ru.ifmo.bdro1.exception.MissileNotFountException;
import ru.ifmo.bdro1.form.MissileForm;

@Controller
@RequestMapping("/missile")
public class MissileController {

    @Autowired
    private MissileService missileService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("missileFormList", missileService.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("missileForm", new MissileForm());
        return "add_missile";
    }

    @PostMapping("/add")
    public String addMissile(@ModelAttribute MissileForm missileForm) {
        Long id = missileService.saveAndGetId(missileForm);
        return "redirect:/missile/get/" + id;
    }

    @GetMapping("/get/{id}")
    public String get(Model model, @PathVariable Long id) {
        try {
            MissileForm missileForm = missileService.findById(id);
            model.addAttribute("missileForm", missileForm);
            return "get_missile";
        } catch (MissileNotFountException e) {
            return "not_found";
        }
    }

    @GetMapping("/name/{missileName}")
    public String name(Model model, @PathVariable String missileName) {
        try {
            MissileForm missileForm = missileService.findByMissileName(missileName);
            model.addAttribute("missileForm", missileForm);
            return "get_missile";
        } catch (MissileNotFountException e) {
            return "not_found";
        }
    }

    @GetMapping("/code/{missileCode}")
    public String code(Model model, @PathVariable String missileCode) {
        try {
            MissileForm missileForm = missileService.findByMissileCode(missileCode);
            model.addAttribute("missileForm", missileForm);
            return "get_missile";
        } catch (MissileNotFountException e) {
            return "not_found";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        try {
            missileService.deleteById(id);
            return "redirect:/missile";
        } catch (EmptyResultDataAccessException e) {
            return "not_found";
        }
    }

}
