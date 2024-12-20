package Excecoes;

public class ClienteNaoEncontradoException extends IllegalArgumentException {
    public ClienteNaoEncontradoException(String message) {
        super(message);
    }
}