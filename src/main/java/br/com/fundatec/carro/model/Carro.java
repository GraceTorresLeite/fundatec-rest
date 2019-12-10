package br.com.fundatec.carro.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;
    private String placa;
    private LocalDate dataFabricacao;
    private LocalDate dataModelo;
    @OneToMany(mappedBy = "carro")
    private Set<Reserva> reservas;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataModelo() {
        return dataModelo;
    }

    public void setDataModelo(LocalDate dataModelo) {
        this.dataModelo = dataModelo;
    }

    public Carro() {
    }

    public Carro(Long id, String nome, String marca, String placa, LocalDate dataFabricacao, LocalDate dataModelo) {
        this.id = id;
        this.nome = nome;
        this.marca =marca;
        this.placa = placa;
        this.dataFabricacao = dataFabricacao;
        this.dataModelo = dataModelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
