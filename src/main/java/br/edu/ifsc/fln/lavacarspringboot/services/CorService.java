package br.edu.ifsc.fln.lavacarspringboot.services;


import br.edu.ifsc.fln.lavacarspringboot.models.Cor;
import br.edu.ifsc.fln.lavacarspringboot.repositories.CorRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void create(Cor cor){
        corRepository.save(cor);
    }

    public Optional<Cor> findId(int id){
        return corRepository.findById(id);
    }

    @Transactional
    public void update(int id, Cor corAtualizada) {
        Optional<Cor> opt = findId(id);
        if (opt.isPresent()) {
            Cor corExistente = opt.get();
            corExistente.setNome(corAtualizada.getNome());
            corRepository.save(corExistente);
        }
    }

    @Transactional
    public void delete(int id){
        Optional<Cor> opt = findId(id);
        Cor cor = opt.get();
        corRepository.delete(cor);
    }

}
