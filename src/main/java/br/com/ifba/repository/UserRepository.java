package br.com.ifba.repository;

import br.com.ifba.entityuser.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// Indica que esta interface é um componente de repositório Spring e será gerenciada pelo Spring
@Repository
// Interface que herda JpaRepository para fornecer métodos padrão de CRUD e mais funcionalidades
public interface UserRepository extends JpaRepository<User, Long> {

    //Optional para test
    Optional<User> findByLogin(String login);

    //Optional para test
    Optional<User> findByLoginAndPassword(String firulas, String number);

}