package br.com.ifba.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data // Anotação do Lombok para gerar getters, setters, toString, etc.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID único do usuário (gerado automaticamente)
    private String name; // Nome do usuário
    private String email; // Email do usuário
    private String password; // Senha do usuário
}