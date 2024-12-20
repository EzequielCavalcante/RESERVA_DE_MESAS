package Cliente;

import java.util.List;
import Excecoes.ClienteNaoEncontradoException;
public class ClienteBO {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public void adicionarCliente(ClienteVO cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }
        clienteDAO.inserirCliente(cliente);
    }

    public List<ClienteVO> listarClientes() {
        List<ClienteVO> clientes = clienteDAO.listarClientes();
        if (clientes.isEmpty()) {
            throw new IllegalArgumentException("Nenhum cliente encontrado.");
        }
        return clientes;
    }

    public void removerCliente(int id) {
        ClienteVO cliente = clienteDAO.buscarClientePorId(id);
        if (cliente == null) {
            throw new ClienteNaoEncontradoException("Cliente com ID " + id + " não encontrado.");
        }
        clienteDAO.removerCliente(id);
    }

    public ClienteVO buscarClientePorId(int id) {
        ClienteVO cliente = clienteDAO.buscarClientePorId(id);
        if (cliente == null) {
            throw new ClienteNaoEncontradoException("Cliente com ID " + id + " não encontrado.");
        }
        return cliente;
    }
}
