package br.com.fundatec.carro.api.Dto;

import java.time.LocalDate;

public class ReservaOutputDto {
    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private CarroOutputDto carroOutputDto;

    public ReservaOutputDto() {
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public CarroOutputDto getCarroOutputDto() {
        return carroOutputDto;
    }

    public void setCarroOutputDto(CarroOutputDto carroOutputDto) {
        this.carroOutputDto = carroOutputDto;
    }
}
