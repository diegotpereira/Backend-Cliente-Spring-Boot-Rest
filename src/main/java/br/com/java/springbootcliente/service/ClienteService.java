package br.com.java.springbootcliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.springbootcliente.model.Cliente;
import br.com.java.springbootcliente.repository.ClienteRepositorio;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepositorio repositorio;

    public Cliente salvarCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    public List<Cliente> buscarTodosCliente() {
        return repositorio.findAll();
    }

    public Optional<Cliente> buscarClientePorId(long id){
        return repositorio.findById(id);
    }

    public boolean verificarSeExisteCliente(long id) {
        if (repositorio.existsById((long) id)) {
            return true;
        }

        return false;
    }

    public Cliente atualizarliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    public void deletarClientePorID(long id) {
        repositorio.deleteById(id);
    }
}
