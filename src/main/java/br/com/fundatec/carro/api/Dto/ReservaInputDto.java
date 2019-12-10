package br.com.fundatec.carro.api.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class ReservaInputDto {

    @NotBlank(message = "campo obrigatorio")
    private String nome;
    @NotNull(message = "O campo inicio não pode ser vazio")
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public ReservaInputDto() {
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
}
