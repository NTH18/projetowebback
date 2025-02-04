package br.com.ifba.service; // Pacote onde a interface de serviço está localizada

// Importa as classes de DTO usadas para transferir dados entre camadas
import br.com.ifba.dto.UsuarioGetResponseDto; // DTO usado para a resposta de dados de usuário
import br.com.ifba.dto.UsuarioPostRequestDto; // DTO usado para o envio de dados de usuário para criação ou atualização
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List; // Importa a classe List para retornar múltiplos itens

// Interface que define os serviços relacionados a usuários
public interface UsuarioIService {

    // Método para salvar um novo usuário, recebe um DTO de solicitação e retorna um DTO de resposta
    UsuarioGetResponseDto salvar(UsuarioPostRequestDto usuarioPostRequestDTO);

    // Método para buscar um usuário por seu ID, recebe um ID e retorna um DTO de resposta
    UsuarioGetResponseDto buscarPorId(Long id);

    // Método para listar todos os usuários, retorna uma lista de DTOs de resposta
    List<UsuarioGetResponseDto> listarTodos();

    Page<UsuarioGetResponseDto> listarTodos(Pageable pageable);
}
