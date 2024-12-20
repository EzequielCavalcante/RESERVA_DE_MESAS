package main;

import Reserva.ReservaBO;
import Reserva.ReservaVO;
import Mesa.MesaVO;
import Cliente.ClienteVO;

import java.time.LocalDate;
import java.util.List;

public class View {

    public static void main(String[] args) {
        try {
            // Instâncias BO
            ReservaBO reservaBO = new ReservaBO();

            // Exemplo de instância de Cliente e Mesa
            ClienteVO cliente1 = new ClienteVO(1, "João", "999999999", "joao@email.com");
            MesaVO mesa1 = new MesaVO(1, 4);

            // Criar uma nova reserva
            ReservaVO novaReserva = new ReservaVO(1, cliente1, mesa1, LocalDate.of(2024, 12, 25));
            reservaBO.adicionarReserva(novaReserva);

            // Listar todas as reservas
            List<ReservaVO> reservas = reservaBO.listarReservas();
            System.out.println("Reservas realizadas:");
            for (ReservaVO reserva : reservas) {
                System.out.println(reserva);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
