package br.com.bluepoints.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity // identifica que a classe Reciclagem é uma entidade
@Table(name = "T_HIST_RECICLAGEM") // define o nome da entidade no BD

public class Reciclagem {

    @Id // demonstra qual atributo será chave primária
    @GeneratedValue ( // forma de se gerar um valor para o campo
            strategy = GenerationType.SEQUENCE, // a estratégia de sequência
            generator = "SEQ_HIST_RECI" // nome da sequência do banco
    )
    @SequenceGenerator( // registro do nome da sequência e suas informações
            name = "SEQ_HIST_RECI",
            sequenceName = "SEQ_HIST_RECI",
            allocationSize = 1
    )
    @Column(name = "id_reciclagem") // nome da coluna no BD
    private Long id;

    @Column(name = "cod_usuario")
    private Long usuario;

    @Column(name = "des_local")
    private String local;

    @Column(name = "dat_reciclagem")
    private LocalDate data;

    @Column(name = "qtd_peso")
    private Double peso;

    public Reciclagem(){}

    public Reciclagem(Long id, Long usuario, String local, LocalDate data, Double peso) {
        this.id = id;
        this.usuario = usuario;
        this.local = local;
        this.data = data;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reciclagem that = (Reciclagem) o;
        return Objects.equals(id, that.id) && Objects.equals(usuario, that.usuario) && Objects.equals(local, that.local) && Objects.equals(data, that.data) && Objects.equals(peso, that.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, local, data, peso);
    }

}
