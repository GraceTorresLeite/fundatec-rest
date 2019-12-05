package br.com.fundatec.carro.Service;


import br.com.fundatec.carro.Repository.CarroRepository;
import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listarCarros(String nome) {

        return carroRepository.listarCarros(nome);
    }


    public Carro consultar(Long id) {
        return carroRepository.consultar(id);
    }

    public Carro incluir(Carro carro) {
        validar(carro);
        return carroRepository.incluir(carro);
    }

    public void validar(Carro carro) {
        if (carro.getDataModelo().isBefore(carro.getDataFabricacao())) {
            throw new RuntimeException("data fabricação deve ser menor que data modelo");

        }
      List marcasValidas = Arrays.asList("Fiat", "Ford", "VolksWagen");
       if (! marcasValidas.contains(carro.getMarca())) {
           throw new RuntimeException("A marca " + carro.getMarca() + "é inválida");
        }

    }
}

