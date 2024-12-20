package Reserva;

import Mesa.MesaVO;
import Cliente.ClienteVO;
import Excecoes.MesaIndisponivelException;
import java.time.LocalDate;
import java.util.List;

public class ReservaBO {

    private ReservaDAO reservaDAO = new ReservaDAO();

    public boolean verificarDisponibilidade(MesaVO mesa, LocalDate data) {
        List<ReservaVO> reservas = reservaDAO.listarReservas();
        for (ReservaVO reserva : reservas) {
            if (reserva.getMesa().getnumMesa() == mesa.getnumMesa() && reserva.getData().equals(data)) {
                return false; // Conflito de data
            }
        }
        return true;
    }

    public void adicionarReserva(ReservaVO reserva) throws Exception {
        if (verificarDisponibilidade(reserva.getMesa(), reserva.getData())) {
            reservaDAO.inserirReserva(reserva);
        } else {
            throw new MesaIndisponivelException("Mesa indisponível no dia solicitado.");
        }
    }

    public List<ReservaVO> listarReservas() {
        return reservaDAO.listarReservas();
    }
}
