package Model;

import javax.persistence.*;

@Entity
@Table(name = "proteina")
public class proteina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproteina;

    @Column(name ="nome_proteina")
    private String nome;

    @Column(name = "preco_custo")
    private Double precoCusto;

    public Integer getIdproteina() {
        return idproteina;
    }

    public void setIdproteina(Integer idproteina) {
        this.idproteina = idproteina;
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
    
    