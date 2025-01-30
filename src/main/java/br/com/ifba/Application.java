package br.com.ifba; // Pacote onde a classe Application está localizada

// Importa as classes necessárias para a inicialização do Spring Boot
import org.springframework.boot.SpringApplication; // Classe que inicializa a aplicação Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication; // Anotação para marcar a classe como uma aplicação Spring Boot

// Anotação @SpringBootApplication marca a classe como a principal para uma aplicação Spring Boot
@SpringBootApplication
public class Application {

    // Método main, ponto de entrada da aplicação
    public static void main(String[] args) {
        // Chama o método run da SpringApplication para inicializar a aplicação Spring Boot
        SpringApplication.run(Application.class, args);
    }
}
