package br.com.fundatec.carro.mapper;

import br.com.fundatec.carro.api.Dto.CarroInputDto;
import br.com.fundatec.carro.api.Dto.CarroOutputDto;
import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarroMapper {
    public CarroOutputDto mapear(Carro carro) {
        CarroOutputDto carroOutputDto = new CarroOutputDto();
        carroOutputDto.setId(carro.getId());
        carroOutputDto.setNome(carro.getNome());
        carroOutputDto.setMarca(carro.getMarca());
        carroOutputDto.setPlaca(carro.getPlaca());
        carroOutputDto.setDataFabricacao(carro.getDataFabricacao());
        carroOutputDto.setDataModelo(carro.getDataModelo());
        return carroOutputDto;
    }
    public List<CarroOutputDto> mapear (List<Carro> carros){
        List<CarroOutputDto> carroOutputDtos = new ArrayList<>();
        for (Carro carro: carros){
            carroOutputDtos.add(mapear(carro));
        }
        return carroOutputDtos;
    }
    public Carro mapear(CarroInputDto carroInputDto){
        Carro carro = new Carro();
        carro.setNome(carroInputDto.getNome());
        carro.setMarca(carroInputDto.getMarca());
        carro.setPlaca(carroInputDto.getPlaca());
        carro.setDataFabricacao(carroInputDto.getDataFabricacao());
        carro.setDataModelo(carroInputDto.getDataModelo());
        return carro;
    }
}
