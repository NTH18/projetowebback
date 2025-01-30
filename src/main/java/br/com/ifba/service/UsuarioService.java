package br.com.ifba.service; // Pacote onde a classe de serviço está localizada

// Importa as dependências necessárias
import br.com.ifba.dao.UsuarioIDao; // DAO para operações de acesso a dados de usuário
import br.com.ifba.dto.UsuarioGetResponseDto; // DTO para a resposta de dados do usuário
import br.com.ifba.dto.UsuarioPostRequestDto; // DTO para a solicitação de criação de usuário
import br.com.ifba.entityuser.Usuario; // Entidade de usuário
import br.com.ifba.mapper.ObjectMapperUtil; // Utilitário para conversão entre objetos
import br.com.ifba.service.UsuarioIService; // Interface de serviço para usuários
import org.springframework.stereotype.Service; // Anotação do Spring para indicar que a classe é um serviço
import java.util.List; // Importa a classe List para manipulação de listas
import java.util.stream.Collectors; // Importa o Collectors para manipulação de streams
import br.com.ifba.exception.BusinessException; // Exceção personalizada para erros de negócio

// Anotação do Spring que indica que a classe é um componente de serviço
@Service
public class UsuarioService implements UsuarioIService {

    private final UsuarioIDao usuarioDAO; // Instância do DAO para acessar o banco de dados de usuários

    // Construtor da classe, recebe o DAO de usuários e o injeta automaticamente pelo Spring
    public UsuarioService(UsuarioIDao usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    // Método para salvar um novo usuário
    @Override
    public UsuarioGetResponseDto salvar(UsuarioPostRequestDto usuarioPostRequestDTO) {
        // Converte o DTO de entrada para a entidade Usuario
        Usuario usuario = ObjectMapperUtil.convert(usuarioPostRequestDTO, Usuario.class);
        // Salva o usuário no banco de dados
        usuario = usuarioDAO.save(usuario);
        // Converte o usuário salvo para o DTO de resposta e retorna
        return ObjectMapperUtil.convert(usuario, UsuarioGetResponseDto.class);
    }

    // Método para buscar um usuário por ID
    @Override
    public UsuarioGetResponseDto buscarPorId(Long id) {
        // Tenta encontrar o usuário no banco de dados usando o ID
        return usuarioDAO.findById(id)
                .map(usuario -> ObjectMapperUtil.convert(usuario, UsuarioGetResponseDto.class)) // Se encontrado, converte para o DTO de resposta
                .orElseThrow(() -> new BusinessException("Usuário não encontrado")); // Se não encontrado, lança uma exceção de negócio
    }

    // Método para listar todos os usuários
    @Override
    public List<UsuarioGetResponseDto> listarTodos() {
        // Busca todos os usuários no banco de dados e converte cada um para o DTO de resposta
        return usuarioDAO.findAll().stream()
                .map(usuario -> ObjectMapperUtil.convert(usuario, UsuarioGetResponseDto.class)) // Converte para DTO
                .collect(Collectors.toList()); // Coleta os resultados em uma lista
    }
}
