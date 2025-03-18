/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "acompanhamento")
public class acompanhamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idacompanhamento;

    @Column(name = "nome_porcao" )
    private String nome;

    @Column(name = "preco_custo")
    private Double precoCusto;

    public Integer getIdacompanhamento() {
        return idacompanhamento;
    }

    public void setIdacompanhamento(Integer idacompanhamento) {
        this.idacompanhamento = idacompanhamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    
}
