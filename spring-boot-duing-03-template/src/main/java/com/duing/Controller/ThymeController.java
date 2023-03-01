package com.duing.Controller;

import com.duing.bean.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeController {

    @RequestMapping("thyme")
    public String index(Model model){
        model.addAttribute("name","<h1>thymeleaf</h1>");
        return "/thymeleaf/index";
    }

    @RequestMapping("thyme2")
    public String index2(Model model){
        Restaurant restaurant = new Restaurant();
        restaurant.setBoss("kd");
        restaurant.setChef("张大仙");

        model.addAttribute("restaurant",restaurant);

        return "/thymeleaf/index";
    }
}
