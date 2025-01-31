package br.com.ifba.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime; // Para incluir o timestamp

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp; // Data e hora do erro
    private int status; // Status HTTP
    private String message; // Mensagem de erro
}
