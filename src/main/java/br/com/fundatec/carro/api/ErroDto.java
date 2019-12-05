package br.com.fundatec.carro.api;

public class ErroDto {
    private String mensagem;

    public String getErro() {
        return mensagem;
    }

    public void setErro(String erro) {
        this.mensagem = erro;
    }
}
