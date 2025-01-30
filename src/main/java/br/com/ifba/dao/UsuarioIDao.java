package br.com.ifba.dao; // Pacote onde a interface está localizada

// Importa a entidade Usuario e o repositório JpaRepository do Spring Data JPA
import br.com.ifba.entityuser.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface que define a camada de acesso a dados para a entidade Usuario
public interface UsuarioIDao extends JpaRepository<Usuario, Long> {
    // Não é necessário implementar métodos, pois JpaRepository fornece implementações padrão para operações CRUD
}
