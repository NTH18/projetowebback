package br.com.ifba.controller;

import br.com.ifba.mapper.ObjectMapperUtil;
import br.com.ifba.dto.UserGetResponseDto;
import br.com.ifba.dto.UserPostRequestDto;
import br.com.ifba.entityuser.User;
import jakarta.validation.Valid;
import br.com.ifba.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Indica que esta classe é um controlador REST
@RestController
// Define o caminho base para os endpoints deste controlador como "/users"
@RequestMapping(path = "/users")
// Gera um construtor com argumentos obrigatórios para campos finais (final)
@RequiredArgsConstructor
public class UserController {
    // Injeta a dependência de UserService automaticamente pelo construtor
    private final UserService userService;

    private final ObjectMapperUtil objectMapperUtil;

    // Define o endpoint POST em "/users/save" para salvar um usuário
    // Especifica que a requisição deve consumir JSON
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid UserPostRequestDto userPostResponseDto) {
        // Retorna a resposta com o status HTTP 201 (Created) e o objeto salvo
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objectMapperUtil.map(userService.save(
                                (objectMapperUtil.map(userPostResponseDto, User.class))),
                        UserGetResponseDto.class));
    }

    // Define o endpoint GET em "/users/findall" para buscar todos os usuários
    // Especifica que a resposta será no formato JSON
    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(Pageable pageable) {
        // Retorna a resposta com o status HTTP 200 (OK) e a lista de usuários
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.userService.findAll(pageable)
                        .map(c -> objectMapperUtil.map(c, UserGetResponseDto.class)));

    }

    // Mapeia a rota DELETE para excluir um recurso com base no ID fornecido
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        // Chama o serviço para excluir o recurso com o ID especificado
        userService.delete(id);
        // Retorna uma resposta com o status HTTP 204 (No Content), indicando que a exclusão foi realizada com sucesso
        return ResponseEntity.noContent().build();
    }

    // Mapeia a rota PUT para atualizar um recurso com base no ID fornecido
    @PutMapping(path = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User user) {
        // Define o ID do objeto user como o ID recebido na URL
        user.setId(id);
        // Chama o serviço para atualizar o recurso com os dados fornecidos
        userService.update(user);
        // Retorna uma resposta com o status HTTP 204 (No Content), indicando que a atualização foi realizada com sucesso
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
// Mapeia requisições HTTP GET para o endpoint "/users/findById/{id}" e define a resposta no formato JSON.
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        // Método para buscar um usuário pelo ID fornecido na URL.
        return ResponseEntity.status(HttpStatus.OK)
                // Retorna uma resposta com o status HTTP 200 (OK).
                .body(objectMapperUtil.map(
                        // Converte o objeto retornado pelo serviço para um DTO antes de enviá-lo na resposta.
                        this.userService.findById(id),
                        // Chama o serviço para buscar o usuário pelo ID.
                        UserGetResponseDto.class));
        // Converte a entidade User para UserGetResponseDto antes de retornar.
    }

}