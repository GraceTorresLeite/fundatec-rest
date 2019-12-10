package br.com.fundatec.carro.api;

import br.com.fundatec.carro.Service.ReservaService;
import br.com.fundatec.carro.api.Dto.ErroDto;
import br.com.fundatec.carro.api.Dto.ReservaInputDto;
import br.com.fundatec.carro.api.Dto.ReservaOutputDto;
import br.com.fundatec.carro.mapper.ReservaMapper;
import br.com.fundatec.carro.model.Reserva;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ReservaApi {
    private final ReservaService reservaService;
    private final ReservaMapper reservaMapper;

    public ReservaApi(ReservaService reservaService, ReservaMapper reservaMapper) {
        this.reservaService = reservaService;
        this.reservaMapper = reservaMapper;
    }
    @PostMapping("/carros/{id}/reservas")
    public ResponseEntity<?> incluirReserva(@Valid @RequestBody ReservaInputDto reservaInputDto,
                                            @PathVariable(value= "id") Long idCarro) {
        Reserva reserva = reservaMapper.mapear(reservaInputDto);
        try {
            reserva = reservaService.incluir(reserva, idCarro);
            ReservaOutputDto reservaOutputDto = reservaMapper.mapear(reserva);
            return ResponseEntity.status(HttpStatus.CREATED).body(reservaOutputDto);
        } catch (RuntimeException e) {
            ErroDto erroDto = new ErroDto();
            erroDto.setErro(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(erroDto);
        }
    }
}
