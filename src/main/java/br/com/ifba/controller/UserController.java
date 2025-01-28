package br.com.ifba.controller;

import br.com.ifba.dto.UserDTO; // Importação do Data Transfer Object (DTO) para a entidade User
import br.com.ifba.service.UserService; // Importação do serviço responsável pela lógica de negócios de usuários
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importação dos códigos de status HTTP
import org.springframework.http.ResponseEntity; // Classe para representar respostas HTTP
import org.springframework.web.bind.annotation.*; // Importação de anotações para controlar endpoints

import java.util.List;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/users") // Define o endpoint base para todas as rotas deste controlador
public class UserController {

    @Autowired // Injeta automaticamente a dependência do serviço UserService
    private UserService userService;

    /**
     * Endpoint para criar um novo usuário.
     * @param userDTO Objeto recebido no corpo da requisição contendo os dados do usuário.
     * @return Retorna o usuário salvo e o status HTTP 201 (Created).
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.saveUser(userDTO); // Chama o serviço para salvar o usuário
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED); // Retorna o usuário salvo com o status CREATED
    }

    /**
     * Endpoint para obter todos os usuários.
     * @return Retorna uma lista de usuários e o status HTTP 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers(); // Chama o serviço para buscar todos os usuários
        return new ResponseEntity<>(users, HttpStatus.OK); // Retorna a lista de usuários com o status OK
    }

    /**
     * Endpoint para obter um usuário pelo ID.
     * @param id ID do usuário que será buscado.
     * @return Retorna o usuário encontrado e o status HTTP 200 (OK).
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO user = userService.getUserById(id); // Chama o serviço para buscar o usuário pelo ID
        return new ResponseEntity<>(user, HttpStatus.OK); // Retorna o usuário com o status OK
    }

    /**
     * Endpoint para atualizar um usuário existente.
     * @param id ID do usuário que será atualizado.
     * @param userDTO Objeto recebido no corpo da requisição contendo os novos dados do usuário.
     * @return Retorna o usuário atualizado e o status HTTP 200 (OK).
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(id, userDTO); // Chama o serviço para atualizar o usuário
        return new ResponseEntity<>(updatedUser, HttpStatus.OK); // Retorna o usuário atualizado com o status OK
    }

    /**
     * Endpoint para deletar um usuário pelo ID.
     * @param id ID do usuário que será deletado.
     * @return Retorna o status HTTP 204 (No Content).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id); // Chama o serviço para deletar o usuário
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna apenas o status NO_CONTENT
    }
}
