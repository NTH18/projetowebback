package br.com.ifba.repository;

import br.com.ifba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}