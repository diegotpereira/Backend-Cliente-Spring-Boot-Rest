package br.com.java.springbootcliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.springbootcliente.model.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    List<Cliente> findByIdade(int idade);
}
