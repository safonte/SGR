package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor") // Nome da tabela no banco de dados
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento
    @Column(name = "idfornecedor") // Nome da coluna no banco de dados
    private int id;

    @Column(name = "razao_social", nullable = false) // Nome da coluna e não pode ser nulo
    private String razaoSocial;

    @Column(name = "cnpj", nullable = false, unique = true) // CNPJ é único e não pode ser nulo
    private String cnpj;

    @Column(name = "logradouro", nullable = false) // Não pode ser nulo
    private String logradouro;

    @Column(name = "Cidade", nullable = false) 
    private String cidade;

    @Column(name = "Estado", nullable = false) 
    private String estado;

    @Column(name = "contato") // Contato (nome)
    private String contato;

    @Column(name = "telefone") // Telefone (string)
    private String telefone;

    // Construtor padrão (obrigatório para o Hibernate)
    public Fornecedor() {
    }

    // Construtor com parâmetros
    public Fornecedor(String razaoSocial, String cnpj, String logradouro, String cidade, String estado, String contato, String telefone) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.contato = contato;
        this.telefone = telefone;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método toString para facilitar a visualização do objeto
    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", contato='" + contato + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}