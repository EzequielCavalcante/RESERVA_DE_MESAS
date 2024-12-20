package main;

import Mesa.MesaBO;
import Mesa.MesaVO;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Instância do MesaBO
        MesaBO mesaBO = new MesaBO();

        // Adicionar mesas
        mesaBO.adicionarMesa(new MesaVO(1, 4));
        mesaBO.adicionarMesa(new MesaVO(2, 6));

        // Listar mesas
        System.out.println("Lista de mesas:");
        List<MesaVO> mesas = mesaBO.listarMesas();
        for (MesaVO mesa : mesas) {
            System.out.println(mesa);
        }

        // Buscar mesa por ID
        MesaVO mesaEncontrada = mesaBO.buscarMesaPorId(1);
        if (mesaEncontrada != null) {
            System.out.println("Mesa encontrada: " + mesaEncontrada);
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }
}
