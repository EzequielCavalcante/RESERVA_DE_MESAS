package Excecoes;
import Cliente.ClienteVO;

public class TelefoneInvalidoException extends IllegalArgumentException {
    
	public TelefoneInvalidoException(String message) {
        super(message);
        
    }
}
