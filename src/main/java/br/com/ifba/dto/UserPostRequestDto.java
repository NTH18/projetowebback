package br.com.ifba.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera automaticamente os métodos getter, setter, toString, equals e hashCode.
@NoArgsConstructor // Gera um construtor sem argumentos.
@AllArgsConstructor // Gera um construtor com todos os campos como argumentos.
public class UserPostRequestDto {

    // Define o nome do campo na requisição JSON como "name".
    @JsonProperty(value = "name")
    @NotBlank(message = "O nome não pode ser vazio!")
    private String name;

    @JsonProperty(value = "login")
    // Define o nome do campo na requisição JSON como "username".
    @Size(min = 4, max = 30, message = "Minimo 4 Caracteres e Maximo 30")
    private String login;

    @JsonProperty(value = "email")
    @Email(message = "email invalido")
    // Define o nome do campo na requisição JSON como "e-mail".
    private String email;

    @JsonProperty(value = "password")
    @NotBlank(message = "A senha nao pode ser vazia!")
    // Define o nome do campo na requisição JSON como "password".
    private String password;

}
