package Reserva;

import java.util.List;

import Mesa.MesaVO;

public interface ServicoDaoReserva<T> {
	
	public List<ReservaVO> listarReservas();
	    
	public void inserirReserva(ReservaVO reserva);
	}


