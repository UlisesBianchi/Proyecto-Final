package com.example.demo.service;


import com.example.demo.model.Reserva;
import com.example.demo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService{


    @Autowired
    private ReservaRepository reservaRepository;


    @Override
    public List<Reserva> listarReserva() {return reservaRepository.findAll();}

    @Override
    public Optional<Reserva> busarReserva(Integer id) {
        return Optional.empty();
    }



    @Override
    public Reserva guardarReserva(Reserva reserva) {return reservaRepository.save(reserva);}

    @Override
    public Reserva actualizarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void eliminarReserva(Integer id) {

    }

    }
