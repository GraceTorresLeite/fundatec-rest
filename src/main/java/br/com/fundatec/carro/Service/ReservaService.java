package br.com.fundatec.carro.Service;

import br.com.fundatec.carro.Repository.ReservaRepository;

import br.com.fundatec.carro.model.Carro;
import br.com.fundatec.carro.model.Reserva;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final CarroService carroService;

    public ReservaService(ReservaRepository reservaRepository, CarroService carroService) {
        this.reservaRepository = reservaRepository;
        this.carroService = carroService;
    }
    public Reserva incluir(Reserva reserva, Long idCarro) {
        validar(reserva);
        Carro carro = carroService.consultar(idCarro);
        reserva.setCarro(carro);
        return reservaRepository.save(reserva);
    }
    public void validar(Reserva reserva) {
        if (reserva.getDataFim().isBefore(reserva.getDataInicio())) {
            throw new RuntimeException("data inicio deve ser menor que data fim");
        }
    }
}
