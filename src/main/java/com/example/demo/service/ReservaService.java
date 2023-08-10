package com.example.demo.service;


import com.example.demo.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {


    List<Reserva> listarReserva();
    Optional<Reserva> busarReserva(Integer id);
    Reserva guardarReserva(Reserva reserva);
    Reserva actualizarReserva(Reserva reserva);

    void  eliminarReserva(Integer id);



}