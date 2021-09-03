package br.com.java.springbootcliente.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "idade")
    private int idade;

    @Column(name = "ativo")
    private boolean ativo;

    public Cliente() {
    }

    public Cliente(long id, String nome, String sobrenome, String endereco, int idade) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.idade = idade;
        this.ativo = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Cliente [ativo=" + ativo + ", endereco=" + endereco + ", id=" + id + ", idade=" + idade + ", nome="
                + nome + ", sobrenome=" + sobrenome + "]";
    }
}
