package br.com.ifba.controller; // Define o pacote onde esta classe está localizada.

import br.com.ifba.client.UsuarioApiClient;
import br.com.ifba.dto.UsuarioGetResponseDto; // Importa a classe DTO usada para retornar os dados do usuário.
import br.com.ifba.dto.UsuarioPostRequestDto; // Importa a classe DTO usada para receber os dados do usuário na requisição.
import br.com.ifba.service.UsuarioIService; // Importa a interface do serviço responsável pela lógica de negócio do usuário.
import jakarta.validation.Valid; // Importa a anotação para validar os dados da requisição.
import lombok.RequiredArgsConstructor; // Importa a anotação do Lombok para gerar um construtor automático com dependências final.
import org.springframework.web.bind.annotation.*; // Importa anotações para definir um controlador REST.
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List; // Importa a classe List para manipular listas de usuários.

@RestController // Indica que esta classe é um controlador REST no Spring Boot, tornando-a responsável por lidar com requisições HTTP.
@RequestMapping("/usuarios") // Define o caminho base da API para este controlador (exemplo: http://localhost:8080/usuarios).
@RequiredArgsConstructor // Lombok gera automaticamente um construtor com os atributos final, facilitando a injeção de dependências.
public class UsuarioController {

    private final UsuarioIService usuarioService; // Dependência do serviço de usuário, injetada automaticamente pelo Lombok.

    // Declara uma instância do cliente HTTP responsável por consumir uma API externa de usuários.
    private final UsuarioApiClient usuarioApiClient;

    // Define um endpoint para buscar um usuário em uma API externa com base no ID informado na URL.
    @GetMapping("/externo/{id}")
    public UsuarioGetResponseDto buscarUsuarioExterno(@PathVariable Long id) {
        // Faz uma chamada à API externa para obter os dados do usuário correspondente ao ID.
        return usuarioApiClient.buscarUsuarioExterno(id);
    }
    /**
     * Endpoint para cadastrar um novo usuário.
     * @param usuarioPostRequestDto Objeto contendo os dados do usuário enviados na requisição.
     * @return Retorna os dados do usuário cadastrado.
     */
    @PostMapping // Mapeia requisições HTTP POST para este método.
    public UsuarioGetResponseDto cadastrarUsuario(@Valid @RequestBody UsuarioPostRequestDto usuarioPostRequestDto) {
        // O @Valid valida os campos do DTO antes de chamar o serviço.
        return usuarioService.salvar(usuarioPostRequestDto); // Chama o serviço para salvar o usuário e retorna o resultado.
    }

    /**
     * Endpoint para buscar um usuário pelo ID.
     * @param id Identificador do usuário a ser buscado.
     * @return Retorna os dados do usuário correspondente ao ID informado.
     */
    @GetMapping("/{id}") // Mapeia requisições HTTP GET com um parâmetro na URL (ID do usuário).
    public UsuarioGetResponseDto buscarUsuario(@PathVariable Long id) {
        // O @PathVariable extrai o ID da URL e passa para o método.
        return usuarioService.buscarPorId(id); // Chama o serviço para buscar o usuário e retorna os dados.
    }
    /**
     * Endpoint para listar todos os usuários cadastrados.
     * @return Retorna uma lista de usuários cadastrados no sistema.
     */
    @GetMapping
    public Page<UsuarioGetResponseDto> listarTodos(Pageable pageable) {
        return usuarioService.listarTodos(pageable);
    }
}
