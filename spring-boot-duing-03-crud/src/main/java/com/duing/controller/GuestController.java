package com.duing.controller;

import com.duing.bean.Guest;
import com.duing.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping()
    public String list(Model model){
        List<Guest> guestList = guestService.findList();
        model.addAttribute("guestList",guestList);
        return "index";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    @PostMapping
    public String add(String name,String role){
        Guest guest = new Guest(name,role);
        guestService.add(guest);

        return "redirect:/guest";
    }

    @RequestMapping("/toUpdate/{name}")
    public String toUpdate(@PathVariable("name") String name , Model model){
        Guest guest = guestService.findGuestByName(name);
        model.addAttribute("guest",guest);
        return "update";
    }

    @PutMapping
    public String update(String name,String role){

        Guest guest = new Guest(name,role);
        guestService.update(guest);

        return "redirect:/guest";
    }

    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String name,Model model){

        guestService.delete(name);

        return "redirect:/guest";
    }



}
