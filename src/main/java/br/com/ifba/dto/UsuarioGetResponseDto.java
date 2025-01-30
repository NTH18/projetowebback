package br.com.ifba.dto; // Pacote onde a classe DTO está localizada

// Importa as anotações do Lombok para geração automática de métodos getters e setters
import lombok.Getter;
import lombok.Setter;

// Classe DTO (Data Transfer Object) que será usada para transportar dados do usuário
@Getter // Lombok irá gerar o método getter para todos os campos da classe
@Setter // Lombok irá gerar o método setter para todos os campos da classe
public class UsuarioGetResponseDto {
    private Long id; // Campo para armazenar o ID do usuário
    private String nome; // Campo para armazenar o nome do usuário
    private String email; // Campo para armazenar o email do usuário
}
