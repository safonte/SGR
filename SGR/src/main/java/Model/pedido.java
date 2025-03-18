package Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column( name = "mesa",nullable = false)
    private int mesa;

    @Column (name = "proteina", nullable = true)
    private String proteina;

    
    @Column(name = "acompanhamento1", nullable = true)
    private String acompanhamento1;

    
    @Column(name = "acompanhamento2", nullable = true)
    private String acompanhamento2;

    @Column(name = "bebida", nullable = true)
    private String bebida;

    @Column(name = "sobremesa", nullable = true)
    private String sobremesa;

    @Column(name="garcon",nullable = false)
    private String garcon;

    @Column(name="data_e_hora", nullable = false)
    private LocalDateTime dataEHora;

    @Column(name="valor_pedido",nullable = false)
    private Double valorPedido;

    @Column(name="forma_pagamento", nullable = false)
    private String formaPagamento;

   
    // Getters e Setters

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getProteina() {
        return proteina;
    }

    public void setProteina(String proteina) {
        this.proteina = proteina;
    }

    public String getAcompanhamento1() {
        return acompanhamento1;
    }

    public void setAcompanhamento1(String acompanhamento1) {
        this.acompanhamento1 = acompanhamento1;
    }

    public String getAcompanhamento2() {
        return acompanhamento2;
    }

    public void setAcompanhamento2(String acompanhamento2) {
        this.acompanhamento2 = acompanhamento2;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }

    public String getGarcon() {
        return garcon;
    }

    public void setGarcon(String garcon) {
        this.garcon = garcon;
    }

    public LocalDateTime getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(LocalDateTime dataEHora) {
        this.dataEHora = dataEHora;
    }

    public Double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(Double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    
  
}
