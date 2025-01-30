package br.com.ifba.exception; // Pacote onde a classe de resposta de erro está localizada

// Importa as anotações do Lombok para simplificação de código
import lombok.AllArgsConstructor; // Para gerar um construtor com todos os parâmetros
import lombok.Getter; // Para gerar automaticamente o método getter para o campo 'message'

@Getter // Lombok irá gerar automaticamente o método getter para o campo 'message'
@AllArgsConstructor // Lombok irá gerar um construtor com todos os parâmetros da classe
public class ErrorResponse {
    private String message; // Campo para armazenar a mensagem de erro
}
