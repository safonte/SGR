package Model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "bebida")
public class bebida  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idbebida;

    @Column(name = "nome_bebida")
    private String nome;

    @Column(name="preco_custo")
    private Double precoCusto;

    // Getters e Setters

    public Integer getIdbebida() {
        return idbebida;
    }

    public void setIdbebida(Integer idbebida) {
        this.idbebida = idbebida;
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
