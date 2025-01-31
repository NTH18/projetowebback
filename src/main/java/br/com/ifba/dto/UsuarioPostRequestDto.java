package br.com.ifba.dto; // Define o pacote onde esta classe está localizada.

import jakarta.validation.constraints.Email; // Importa a anotação para validar e-mails.
import jakarta.validation.constraints.NotBlank; // Importa a anotação para garantir que o campo não esteja em branco.
import jakarta.validation.constraints.Size; // Importa a anotação para definir restrições de tamanho nos campos.
import lombok.Getter; // Importa a anotação para gerar automaticamente os métodos getter.
import lombok.Setter; // Importa a anotação para gerar automaticamente os métodos setter.

@Getter // Lombok gera automaticamente os métodos getter para todos os atributos.
@Setter // Lombok gera automaticamente os métodos setter para todos os atributos.
public class UsuarioPostRequestDto { // DTO para receber dados ao cadastrar um usuário.

    @NotBlank(message = "O nome é obrigatório.")
    // Garante que o nome não seja nulo nem contenha apenas espaços em branco.

    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    // Define que o nome deve ter pelo menos 3 e no máximo 100 caracteres.
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório.")
    // Garante que o e-mail não seja nulo nem contenha apenas espaços em branco.

    @Email(message = "O e-mail deve ser válido.")
    // Valida se o e-mail está em um formato correto (exemplo@dominio.com).
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    // Garante que a senha não seja nula nem contenha apenas espaços em branco.

    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    // Define que a senha deve ter no mínimo 6 caracteres.
    private String senha;
}
