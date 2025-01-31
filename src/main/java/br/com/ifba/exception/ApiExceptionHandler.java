package br.com.ifba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Define que esta classe será um manipulador global de exceções para os controladores REST.
public class ApiExceptionHandler {

    /**
     * Captura erros de validação e retorna mensagens amigáveis.
     * Exemplo: Se um campo obrigatório estiver em branco, retorna uma resposta indicando qual campo está errado.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class) // Intercepta exceções de validação de argumentos de método.
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Retorna status HTTP 400 (Bad Request) quando essa exceção ocorre.
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>(); // Cria um mapa para armazenar os erros.

        for (FieldError error : ex.getBindingResult().getFieldErrors()) { // Percorre todos os erros de validação encontrados.
            errors.put(error.getField(), error.getDefaultMessage()); // Associa o nome do campo à mensagem de erro correspondente.
        }

        return errors; // Retorna o mapa contendo os erros de validação.
    }

    /**
     * Captura erros de regra de negócio e retorna mensagens personalizadas.
     * Exemplo: Se um e-mail já estiver cadastrado no banco, lança uma BusinessException com a mensagem "E-mail já cadastrado".
     */
    @ExceptionHandler(BusinessException.class) // Intercepta exceções personalizadas de regra de negócio.
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Retorna status HTTP 400 (Bad Request) quando essa exceção ocorre.
    public ErrorResponse handleBusinessException(BusinessException ex) {
        // Retorna a resposta com timestamp, status HTTP e a mensagem de erro.
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
