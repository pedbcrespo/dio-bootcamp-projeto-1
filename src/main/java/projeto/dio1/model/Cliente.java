package projeto.dio1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
    @Id
    private Long id;
    private String nome;

    @ManyToOne
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getCepEndereco() {
        return endereco.getCep();
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
