package com.kauarasera.receiptmanager.controller;

import com.kauarasera.receiptmanager.entity.Person;
import com.kauarasera.receiptmanager.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    // Show the form
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "person-form";
    }

    //URL to list people
    @GetMapping("/list")
    public String listPersons(Model model) {
        model.addAttribute("persons", repository.findAll());
        return "person-list";
    }

    // Receive the form POST
    @PostMapping("/save")
    public String savePerson(@ModelAttribute("person") Person person) {
        repository.save(person);
        return "redirect:/person/form?success";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        model.addAttribute("person", person);
        return "person-form";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/person/list";
    }

}

