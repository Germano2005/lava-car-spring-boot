package br.edu.ifsc.fln.lavacarspringboot.controllers;


import br.edu.ifsc.fln.lavacarspringboot.models.Cor;
import br.edu.ifsc.fln.lavacarspringboot.repositories.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CorController {

    @Autowired
    private CorRepository corRepository;

    @GetMapping("/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("cadastro-cor");
        List<Cor> cores = corRepository.findAll();
        mv.addObject("cores", cores);

        return mv;
    }
}
