package com.list.anime.controller;

import com.list.anime.domain.Anime;
import com.list.anime.service.AnimeListServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AnimeListController {@Autowired
private AnimeListServer service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Anime> listanime = service.listAll();
        model.addAttribute("listanime", listanime);
        System.out.print("Get / ");
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("anime", new Anime());
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAnime(@ModelAttribute("anime") Anime std) {
        service.save(std);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditAnimeList(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Anime std = service.get(id);
        mav.addObject("anime", std);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteanime(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
