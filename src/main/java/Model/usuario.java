/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "usuario")
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "data_hora", nullable = false) // Nome da coluna no banco de dados
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora; // Alterado para dataHora

    // Construtor padrão (obrigatório para o Hibernate)
    public usuario() {}

    // Construtor com parâmetros
    public usuario(String nome, String senha, String tipo, Date dataHora) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    // Getters e Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
    
}