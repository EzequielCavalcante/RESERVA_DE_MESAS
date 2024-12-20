package Mesa;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import main.ServicoDao;

public class MesaVO  {
	private int numero;
	private int capacidade;
	
	public MesaVO(int num, int capacidade) {
		this.numero = num;
		this.capacidade = capacidade;
	}

	public void setnumMesa(int num) {
		this.numero = num;
	}
	
	public int setCapacidadeMesa(int capaz) {
		this.capacidade = capaz;
		return capacidade;
		
	}
	
	public int getnumMesa() {
		return this.numero;
	}
	
	public int getCapazMesa() {
		return this.capacidade;
	}
	
    public String toString() {
        return "Cliente{" +
                "numero='" + numero + '\'' +
                ", capacidade='" + capacidade + '}';
    }
}




