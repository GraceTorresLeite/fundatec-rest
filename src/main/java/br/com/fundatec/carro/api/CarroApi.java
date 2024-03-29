package br.com.fundatec.carro.api;

import br.com.fundatec.carro.Service.CarroService;
import br.com.fundatec.carro.api.Dto.CarroInputDto;
import br.com.fundatec.carro.api.Dto.CarroOutputDto;
import br.com.fundatec.carro.api.Dto.ErroDto;
import br.com.fundatec.carro.model.Carro;
import br.com.fundatec.carro.mapper.CarroMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
public class CarroApi {

    private final CarroService carroService;
    private final CarroMapper carroMapper;

    public CarroApi(CarroService carroService, CarroMapper carroMapper) {

        this.carroService = carroService;
        this.carroMapper = carroMapper;
    }

    @GetMapping("carros") // retorna dados
    public ResponseEntity<List<CarroOutputDto>> getCarro(@RequestParam(required = false, defaultValue = "") String nome) {
        List<Carro> carros = carroService.listarCarros(nome);
        if (carros.size() == 0) {
            return ResponseEntity.noContent()
                    .build();
        }
        List<CarroOutputDto> carrosOutputDto = carroMapper.mapear(carros);

        return ResponseEntity.ok(carrosOutputDto);
    }


    @GetMapping("/carros/{id}")
    public ResponseEntity<CarroOutputDto> getCarro(@PathVariable() Long id) {
        Carro carro = carroService.consultar(id);
        if (carro != null) {
            CarroOutputDto carroOutputDto = carroMapper.mapear(carro);
            return ResponseEntity.ok(carroOutputDto);
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/carros")
    public ResponseEntity<?> incluir(@Valid @RequestBody CarroInputDto carroInputDto) {
        Carro carro = carroMapper.mapear(carroInputDto);
        try {
            carro = carroService.incluir(carro);
            CarroOutputDto carroOutputDto = carroMapper.mapear(carro);
            return ResponseEntity.status(HttpStatus.CREATED).body(carroOutputDto);
        } catch (RuntimeException e) {
            ErroDto erroDto = new ErroDto();
            erroDto.setErro(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(erroDto);
        }
    }

    @GetMapping("/carros/datas")
    public ResponseEntity<List<CarroOutputDto>> listar(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        List<Carro> carros = carroService.listarCarros(dataInicio, dataFim);
        return getListResponseEntityCarroOutputDto(carros);
    }

    @PutMapping("/carros/{id}")
    public ResponseEntity<?> atualizaCarro(@PathVariable Long id,
                                           @Valid @RequestBody CarroInputDto carroInputDto){
        Carro carro = carroMapper.mapear(carroInputDto);
        carro  = carroService.atualizar(id, carro);
        CarroOutputDto  carroOutputDto = carroMapper.mapear(carro);
        return ResponseEntity.ok(carroOutputDto);
    }

    private ResponseEntity<List<CarroOutputDto>> getListResponseEntityCarroOutputDto(List<Carro> carros) {
        if (carros.size() == 0) {
            return ResponseEntity.noContent()
                    .build();
        }
        List<CarroOutputDto> carrosOutputDto = carroMapper.mapear(carros);
        return ResponseEntity.ok(carrosOutputDto);
    }
}


