package br.com.fundatec.carro.api;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CarroInputDto {

    @NotBlank(message = "campo obrigatorio")
    private String nome;

    @NotEmpty(message = "O campo marca não pode ser vazio")
    private String marca;

    @Pattern(regexp = "^[A-Z]{3}[0-9]{4}$", message = "Placa inválida")
    @NotBlank(message = "campo obrigatorio")
    private String placa;
    @NotNull
    @Past(message = "tem que ser no passado")
    private LocalDate dataFabricacao;
    @NotNull
    private LocalDate dataModelo;


    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate data_Fabricacao) {
        this.dataFabricacao = data_Fabricacao;
    }

    public LocalDate getDataModelo() {
        return dataModelo;
    }

    public void setDataModelo(LocalDate data_Modelo) {
        this.dataModelo = data_Modelo;
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

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca){this.marca = marca; }
}