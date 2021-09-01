package br.com.java.springbootcliente.model;

import java.util.ArrayList;
import java.util.List;

public class Message {

    private String message = "";
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private String error = "";

    public Message(String message, List<Cliente> clientes, String error) {
        this.message = message;
        this.clientes = clientes;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
