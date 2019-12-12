package br.com.fundatec.carro.Service;


import br.com.fundatec.carro.Repository.CarroRepository;
import br.com.fundatec.carro.Repository.CarroRepositoryFakeGrace;
import br.com.fundatec.carro.model.Carro;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {

    private final CarroRepositoryFakeGrace carroRepositoryFakeGrace;
    private final CarroRepository carroRepository;

    public CarroService(CarroRepositoryFakeGrace carroRepositoryFakeGrace, CarroRepository carroRepository) {
        this.carroRepositoryFakeGrace = carroRepositoryFakeGrace;
        this.carroRepository = carroRepository;
    }

    public List<Carro> listarCarros(String nome) {

        return carroRepository.findByNomeContainingIgnoreCase(nome);

    }

    public Carro consultar(Long id) {

        return carroRepository.findById(id).orElse(null);
    }

    public Carro incluir(Carro carro) {
        validar(carro);
        return carroRepository.save(carro);
    }

    public void validar(Carro carro) {
        if (carro.getDataModelo().isBefore(carro.getDataFabricacao())) {
            throw new RuntimeException("data fabricação deve ser menor que data modelo");
        }
        List marcasValidas = Arrays.asList("Fiat", "Ford", "VolksWagen");
        if (!marcasValidas.contains(carro.getMarca())) {
            throw new RuntimeException("A marca " + carro.getMarca() + "é inválida");
        }
    }
    public List<Carro> listarCarros(LocalDate dataInicio, LocalDate dataFim) {
        return carroRepository.findByDataFabricacaoBetween(dataInicio,dataFim);
    }
    public Carro atualizar(Long idCarro, Carro carroParaAtualizacao){
        Carro carro = consultar(idCarro);
        if(carro != null){
            carro.setNome(carroParaAtualizacao.getNome());
            carro.setMarca(carroParaAtualizacao.getMarca());
            carro.setPlaca(carroParaAtualizacao.getPlaca());
            carro.setDataFabricacao(carroParaAtualizacao.getDataFabricacao());
            carro.setDataModelo(carroParaAtualizacao.getDataModelo());
            carro = carroRepository.save(carro);
        }
        return  carro;
    }

}

