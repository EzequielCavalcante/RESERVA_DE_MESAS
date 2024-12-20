package Cliente;

import java.util.List;

import Mesa.MesaVO;

public interface ServicoDaoCliente<T> {
	public ClienteVO buscarClientePorId(int id) throws Exception;

    
    public List<ClienteVO> listarClientes();
	}


