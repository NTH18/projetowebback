package br.com.ifba.controller; // Pacote onde a classe está localizada

// Importa as anotações do Spring para construir o controlador REST
import org.springframework.web.bind.annotation.*;

@RestController // Anotação que indica que esta classe é um controlador REST (vai responder a requisições HTTP)
@RequestMapping("/usuarios") // Define a URL base para as requisições que este controlador vai responder
public class UsuarioController { // Definição da classe controladora para gerenciar os usuários

    // Mapeia uma requisição GET para o caminho "/usuarios/{id}", onde {id} é um parâmetro variável
    @GetMapping("/{id}")
    public String getUsuario(@PathVariable Long id) { // O parâmetro id será extraído da URL da requisição
        return "Usuário com ID " + id; // Retorna uma mensagem com o ID do usuário
    }
}
