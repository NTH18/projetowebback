package br.com.ifba.dto;

import lombok.Data;

@Data // Anotação do Lombok para gerar getters, setters, toString, etc.
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
}