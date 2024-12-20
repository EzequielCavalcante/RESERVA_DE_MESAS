package Mesa;

import java.util.List;

import Mesa.MesaVO;

public interface ServicoDaoMesa<T> {
	


	public void inserirMesa(MesaVO mesa);

	    
    public List<MesaVO> listarMesas();
    
    public MesaVO buscarMesaPorId(int id);
	}


