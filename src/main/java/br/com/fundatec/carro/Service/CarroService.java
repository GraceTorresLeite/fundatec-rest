package br.com.fundatec.carro.Service;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {

    public List<String> listarCarros(){
        List<String> carros = Arrays.asList("Mustange",
                "Fusca",
                "Fumbica",
                "Celta",
                "Uno com escada");
        return carros;
    }
}