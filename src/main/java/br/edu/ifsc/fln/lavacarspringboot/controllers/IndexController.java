package br.edu.ifsc.fln.lavacarspringboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index");
    }


}
