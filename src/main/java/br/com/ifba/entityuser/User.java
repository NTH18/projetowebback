package br.com.ifba.entityuser;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
// Anotação para indicar que esta classe é uma entidade JPA
@Entity
// Gera automaticamente os métodos getters, setters, equals, hashCode e toString
@Data
// Gera um construtor sem argumentos
@NoArgsConstructor
// Gera um construtor com todos os argumentos
@AllArgsConstructor
// Define o nome da tabela no banco de dados como "users"
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
@Builder
public class User extends br.com.ifba.entity.PersistenceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Define que este campo será uma coluna na tabela
    @Column(name = "name", nullable = false)
    private String name;

    // Define que este campo será uma coluna na tabela
    @Column (name = "login",nullable = false, unique = true)
    private String login;

    // Define que este campo será uma coluna na tabela
    @Column(name = "email",nullable = false, unique = true)
    private String email;

    // Define que este campo será uma coluna na tabela
    @Column(name = "password",nullable = false)
    private String password;
}