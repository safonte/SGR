package Model;

import javax.persistence.*;

@Entity
@Table(name = "sobremesa")
public class sobremesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsobremesa;

    @Column(name = "nome_sobremesa")
    private String nome;

    @Column(name ="preco_custo")
    private Double precoCusto;

    // Getters e Setters

    public Long getIdsobremesa() {
        return idsobremesa;
    }

    public void setIdsobremesa(Long idsobremesa) {
        this.idsobremesa = idsobremesa;
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

