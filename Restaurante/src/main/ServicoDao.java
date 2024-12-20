package main;

import java.util.List;

import Mesa.MesaVO;

public interface ServicoDao<T> {
	


	    T buscar(MesaVO mesa);

	    
	    List<T> listar();
	}


