package br.com.ifba.exception; // Pacote onde a classe está localizada

// Importa as anotações e classes necessárias para manipulação de exceções e respostas HTTP
import org.springframework.http.HttpStatus; // Para definir o status da resposta HTTP
import org.springframework.web.bind.annotation.RestControllerAdvice; // Para criar um manipulador global de exceções em controladores REST
import org.springframework.web.bind.annotation.ExceptionHandler; // Para lidar com exceções específicas
import org.springframework.web.bind.annotation.ResponseStatus; // Para definir o status da resposta HTTP

@RestControllerAdvice // Anotação que permite capturar exceções em controladores REST em toda a aplicação
public class ApiExceptionHandler { // Classe que manipula exceções e gera respostas apropriadas

    // Método que lida com exceções do tipo BusinessException
    @ExceptionHandler(BusinessException.class) // Define que este método lida com exceções do tipo BusinessException
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Define que a resposta HTTP terá o status 400 (BAD_REQUEST)
    public ErrorResponse handleBusinessException(BusinessException ex) { // Método que recebe a exceção e retorna uma resposta de erro
        return new ErrorResponse(ex.getMessage()); // Cria e retorna uma instância de ErrorResponse com a mensagem da exceção
    }
}
