package br.com.ifba.repository;

import br.com.ifba.entityuser.User;
import br.com.ifba.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.BeforeEach;
import jakarta.validation.ConstraintViolationException;
import org.assertj.core.api.Assertions;


import java.util.Optional;

@DataJpaTest // Configuração para testes com JPA.
@DisplayName("Test for User Repository")
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    //testa se um usuário pode ser encontrado pelo login com sucesso.

    @Test
    @DisplayName("Find user by login when successful")
    public void findByLogin_whenSuccessful() {
        Optional<User> userFound = this.userRepository.findByLogin("Firulas");

        Assertions.assertThat(userFound.isPresent()).isTrue(); // Verifica se o usuário foi encontrado.
        Assertions.assertThat(userFound).isNotNull(); // Garante que o objeto retornado não é nulo.
        Assertions.assertThat(userFound.get().getEmail()).isEqualTo("firulas@email.com"); // Verifica se o login está correto.
    }

    //Testa a busca por login quando o usuário não existe.

    @Test
    @DisplayName("Find user by login when User not found")
    public void findByLogin_whenUserNotFound() {
        Optional<User> userFound = this.userRepository.findByLogin("non_existent_user");
        Assertions.assertThat(userFound).isNotPresent(); // Verifica que nenhum usuário foi encontrado.
    }

    //Testa a busca por login e senha quando bem-sucedida.

    @Test
    @DisplayName("Find user by login and password when successful")
    public void findByLoginAndSenha_whenSuccessful() {
        Optional<User> userFound = this.userRepository.findByLoginAndPassword("Firulas", "123");

        Assertions.assertThat(userFound.isPresent()).isTrue(); // Confirma que o usuário foi encontrado.
        Assertions.assertThat(userFound.get().getEmail()).isEqualTo("firulas@email.com"); // Verifica o login.
        Assertions.assertThat(userFound.get().getPassword()).isEqualTo("123"); // Verifica a senha.
    }

    //Testa a busca por login e senha quando o usuário não existe.

    @Test
    @DisplayName("Find user by login and password when User not found")
    public void findByLoginAndSenha_whenUserNotFound() {
        Optional<User> userFound = this.userRepository.findByLoginAndPassword("Firulas", "123");
        Assertions.assertThat(userFound).isNotPresent(); // Garante que o usuário não existe.
    }

    //Testa a tentativa de salvar um usuário sem nome, esperando uma exceção.

    @Test
    @DisplayName("Save throws ConstraintViolationException when name is empty")
    public void saveThrowsConstraintViolationException_whenNameIsEmpty() {
        User user = new User(); // Cria um usuário sem nome.

        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> this.userRepository.save(user))
                .withMessageContaining("The User name cannot be empty"); // Verifica se a exceção foi lançada.
    }

    //Método executado antes de cada teste para preparar os dados.

    @BeforeEach
    public void setUp() {
        User user = User.builder()
                .name("Firulas")
                .password("123")
                .email("firulas@email.com")
                .build();
        this.userRepository.save(user); // Salva um usuário no banco antes de cada teste.
    }

    //Método auxiliar para criar um usuário de teste.

    private User createUsuario() {
        return User.builder()
                .name("Firulas")
                .email("firulas@email.com")
                .password("123")
                .build();
    }

    //Método auxiliar para salvar um usuário no banco.

    private void saveUser(User user) {
        this.userRepository.save(user);
    }

}
