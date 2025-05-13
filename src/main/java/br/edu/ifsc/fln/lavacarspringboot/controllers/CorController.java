package br.edu.ifsc.fln.lavacarspringboot.controllers;


import br.edu.ifsc.fln.lavacarspringboot.models.Cor;
import br.edu.ifsc.fln.lavacarspringboot.services.CorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id){
        corService.delete(id);
        return new ModelAndView("redirect:/cor");
    }

    /*@GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("cadastro-cor");
        Optional<Cor> corOpt = corService.findId(id);
        if (corOpt.isPresent()) {
            mv.addObject("cor", corOpt.get());
        }
        return mv;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView modify(@PathVariable int id, Cor corAtualizada) {
        corService.update(id, corAtualizada);
        return new ModelAndView("redirect:/cor");


    }*/


}
