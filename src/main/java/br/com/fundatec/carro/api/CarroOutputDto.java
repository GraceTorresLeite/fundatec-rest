package br.com.fundatec.carro.api;

public class CarroOutputDto {

    private Long id;
    private String nome;

    public CarroOutputDto() {
    }

    public CarroOutputDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;

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


}