package br.com.java.springbootcliente.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.java.springbootcliente.model.Cliente;
import br.com.java.springbootcliente.model.Message;
import br.com.java.springbootcliente.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "http://localhost:8000")
public class ClienteControle {
    
    @Autowired
    ClienteService service;

    @PostMapping("/novo")
    public ResponseEntity<Message> addNovoCliente(@RequestBody Cliente cliente) {
        
        try {
            Cliente returnarCliente = service.salvarCliente(cliente);

            return new ResponseEntity<Message>(
                    new Message("Adicionado com sucesso!", Arrays.asList(returnarCliente), ""), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Message>(new Message("Falha ao salvar um novo cliente!", null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/encontrarUm/{id}")
    public ResponseEntity<Message> buscarClientePorId(@PathVariable long id) {
        try {
            Optional<Cliente> optCliente = service.buscarClientePorId(id);

            if (optCliente.isPresent()) {
                return new ResponseEntity<Message>(new Message("Sucesso! Recuperado um cliente com id = " + id, Arrays.asList(optCliente.get()), ""), HttpStatus.OK);
            } else {
                return new ResponseEntity<Message>(new Message("Falha -> Não foi encontrado um cliente com id = " + id, null, ""), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<Message>(new Message("Falha", null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarTodosClientes")
    public ResponseEntity<Message> buscarTodosClientes() {
        try {
            List<Cliente> buscarClientes = service.buscarTodosCliente();

            return new ResponseEntity<Message>(new Message("Obtenha informações de todos os clientes!", buscarClientes, ""), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Message>(new Message("Falha!", null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletarPorID/{id}")
    public ResponseEntity<Message> deletarClientePorID(@PathVariable long id) {
        try {
            if (service.verificarSeExisteCliente(id)) {
                service.deletarClientePorID(id);

                return new ResponseEntity<Message>(new Message("Sucesso! Deletado cliente com id = " + id, null, ""), HttpStatus.OK);
            } else {
                
                return new ResponseEntity<Message>(new Message("Falha! Não foi possível encontrar cliente " + "com id = " + id, null, ""), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<Message>(new Message("Falha", null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/atualizarPorId/{id}")
    public ResponseEntity<Message> atualizarClientePorID(@RequestBody Cliente _cliente, @PathVariable long id) {
        try {
            if (service.verificarSeExisteCliente(id)) {
                Cliente cliente = service.buscarClientePorId(id).get();

                // definir novos valores para o cliente
                cliente.setNome(_cliente.getNome());
                cliente.setSobrenome(_cliente.getSobrenome());
                cliente.setEndereco(_cliente.getEndereco());
                cliente.setIdade(_cliente.getIdade());

                // salvar a mudança no banco de dados
                service.atualizarliente(cliente);

                return new ResponseEntity<Message>(new Message("Sucesso! Ataulizado cliente com " + "com id = " + id, Arrays.asList(cliente), ""), HttpStatus.OK);
            } else {
                return new ResponseEntity<Message>(new Message("Falha! Não foi posível encontrar o cliente " + "com id = " + id, null, ""), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<Message>(new Message("Falha", null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
