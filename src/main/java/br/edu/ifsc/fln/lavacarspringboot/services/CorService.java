package br.edu.ifsc.fln.lavacarspringboot.services;


import br.edu.ifsc.fln.lavacarspringboot.models.Cor;
import br.edu.ifsc.fln.lavacarspringboot.repositories.CorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorService {

    @Autowired
    CorRepository corRepository;

    public List<Cor> list(){
        return corRepository.findAll();
    }

    public void create(Cor cor){
        corRepository.save(cor);
    }

    public Optional<Cor> findId(int id){
        return corRepository.findById(id);
    }

}
