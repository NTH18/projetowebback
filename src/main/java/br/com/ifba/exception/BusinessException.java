package br.com.ifba.exception; // Pacote onde a classe de exceção está localizada

// Define uma exceção personalizada que estende RuntimeException
public class BusinessException extends RuntimeException {

    // Construtor da exceção, recebe uma mensagem de erro e passa para a classe pai (RuntimeException)
    public BusinessException(String message) {
        super(message); // Chama o construtor da classe RuntimeException com a mensagem fornecida
    }
}
