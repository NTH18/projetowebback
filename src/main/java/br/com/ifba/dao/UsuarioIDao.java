package br.com.ifba.dao; // Define o pacote onde esta interface está localizada.

import br.com.ifba.entityuser.Usuario; // Importa a entidade Usuario.
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository do Spring Data JPA.

public interface UsuarioIDao extends JpaRepository<Usuario, Long> {
    // Interface que representa o repositório da entidade Usuario.
    // JpaRepository fornece métodos prontos para operações de CRUD.

    boolean existsByEmail(String email);
    // Método personalizado para verificar se um usuário com o email especificado já existe no banco de dados.
    // O Spring Data JPA irá gerar automaticamente a implementação deste método com base no nome do método.
}
