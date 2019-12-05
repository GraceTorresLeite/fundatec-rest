package br.com.fundatec.carro.api;

public class CarroOutputDto {

    private Long id;
    private String nome;
    private String marca;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    private String placa;

    public CarroOutputDto() {
    }

    public CarroOutputDto(Long id, String nome, String marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;

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


    public String getMarca() { return marca; }

    public void setMarca(String marca) { this.marca = marca;}
}
