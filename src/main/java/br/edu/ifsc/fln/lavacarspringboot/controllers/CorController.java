package br.edu.ifsc.fln.lavacarspringboot.controllers;


import br.edu.ifsc.fln.lavacarspringboot.models.Cor;
import br.edu.ifsc.fln.lavacarspringboot.repositories.CorRepository;
import br.edu.ifsc.fln.lavacarspringboot.services.CorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cor")
public class CorController {

    private CorService corService;

    public CorController(CorService corService) {
        this.corService = corService;
    }

    @GetMapping
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("cor");
        List<Cor> cores = corService.list();
        mv.addObject("cores", cores);

        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView register(){
        return new ModelAndView("cadastro-cor");
    }

    @PostMapping("/cadastro")
    public ModelAndView create(Cor cor){
        corService.create(cor);
        return new ModelAndView("redirect:/cor");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView mv = new ModelAndView("cadastro-cor");
        mv.addObject("cores", corService.findId(id));
        return mv;
    }


}
