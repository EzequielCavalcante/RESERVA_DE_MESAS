package Mesa;

import java.util.List;

public class MesaBO {

    private MesaDAO mesaDAO = new MesaDAO();

    public void adicionarMesa(MesaVO mesa) {
        if (mesa.getCapazMesa() <= 0) {
            throw new IllegalArgumentException("A capacidade da mesa deve ser maior que 0.");
        }
        if (mesaDAO.buscarMesaPorId(mesa.getnumMesa()) != null) {
            throw new IllegalArgumentException("Já existe uma mesa com este número.");
        }
        mesaDAO.inserirMesa(mesa);
    }

    public List<MesaVO> listarMesas() {
        List<MesaVO> mesas = mesaDAO.listarMesas();
        if (mesas.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma mesa encontrada.");
        }
        return mesas;
    }

    public void removerMesa(int id) {
        MesaVO mesa = mesaDAO.buscarMesaPorId(id);
        if (mesa == null) {
            throw new IllegalArgumentException("Mesa com ID " + id + " não encontrada.");
        }
        mesaDAO.removerMesa(id);
    }

    public MesaVO buscarMesaPorId(int id) {
        MesaVO mesa = mesaDAO.buscarMesaPorId(id);
        if (mesa == null) {
            throw new IllegalArgumentException("Mesa com ID " + id + " não encontrada.");
        }
        return mesa;
    }
}
