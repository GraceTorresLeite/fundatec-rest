package br.com.fundatec.carro.Repository;


import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CarroRepository {
    private static List<Carro> listaCarros = null;

    public List<Carro> listarCarros(String nome) {
        List<Carro> listaResultado = new ArrayList<>();

        for (Carro carro : getListaCarros()) {
            if (carro.getNome().toLowerCase().contains(nome.toLowerCase())) {
                listaResultado.add(carro);
            }
        }
        return listaResultado;
    }

    public Carro consultar(Long id) {
        for (Carro carro : getListaCarros()) {
            if (carro.getId().equals(id)) {
                return carro;
            }
        }
        return null;
    }


    public Carro incluir(Carro carro) {
        carro.setId(new Long(getListaCarros().size() + 1));
        listaCarros.add(carro);
        return carro;
    }
    //Carro(Long id, String nome, String marca, String placa, LocalDate dataFabricacao, LocalDate dataModelo)
    private static List<Carro> getListaCarros() {
        if (listaCarros == null) {
            listaCarros = new ArrayList<>();
            listaCarros.add(new Carro(1L, "Mustang", "MAX1000", "Mustang", LocalDate.of(2019, 12, 4), LocalDate.of(2109, 12, 4)));
            listaCarros.add(new Carro(2L, "Uno com escada", "Fiat ","ABC1234",LocalDate.of(2019, 12, 4), LocalDate.of(2109, 12, 4)));
            listaCarros.add(new Carro(3L, "Chevette","chevrollet", "ASD1235",LocalDate.of(2019, 12, 4), LocalDate.of(2109, 12, 4)));
        }

        return listaCarros;
    }

}



