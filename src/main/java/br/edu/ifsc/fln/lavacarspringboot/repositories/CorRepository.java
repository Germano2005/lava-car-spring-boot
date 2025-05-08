package br.edu.ifsc.fln.lavacarspringboot.repositories;


import br.edu.ifsc.fln.lavacarspringboot.models.Cor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorRepository extends JpaRepository<Cor, Integer> {

}
