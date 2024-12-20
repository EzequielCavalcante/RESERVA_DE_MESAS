package Reserva;

import Cliente.ClienteVO;
import Mesa.MesaVO;

import java.time.LocalDate;

public class ReservaVO {
    private int id;
    private ClienteVO cliente;
    private MesaVO mesa;
    private LocalDate data;

    public ReservaVO(int id, ClienteVO cliente, MesaVO mesa, LocalDate data) {
        this.id = id;
        this.cliente = cliente;
        this.mesa = mesa;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public MesaVO getMesa() {
        return mesa;
    }

    public void setMesa(MesaVO mesa) {
        this.mesa = mesa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReservaVO{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", mesa=" + mesa +
                ", data=" + data +
                '}';
    }
}
