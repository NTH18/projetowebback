package br.com.ifba.entityuser; // Pacote onde a classe está localizada

// Importa as anotações do Jakarta Persistence e Lombok, além de outras classes necessárias
import br.com.ifba.entity.PersistenceEntity; // Classe base que fornece o campo 'id' para a entidade
import jakarta.persistence.*; // Para trabalhar com JPA (Java Persistence API)
import lombok.*; // Para gerar os métodos automaticamente com Lombok

@Getter // Lombok irá gerar o método getter para todos os campos da classe
@Setter // Lombok irá gerar o método setter para todos os campos da classe
@NoArgsConstructor // Lombok irá gerar um construtor sem parâmetros
@AllArgsConstructor // Lombok irá gerar um construtor com todos os parâmetros
@Entity // Marca a classe como uma entidade JPA que será mapeada para uma tabela no banco de dados
@Table(name = "usuarios") // Define o nome da tabela no banco de dados como 'usuarios'
public class Usuario extends PersistenceEntity { // A classe 'Usuario' herda de 'PersistenceEntity', que já tem o campo 'id'

    @Column(nullable = false, unique = true) // Define que o campo 'nome' não pode ser nulo e deve ser único
    private String nome; // Campo para armazenar o nome do usuário

    @Column(nullable = false, unique = true) // Define que o campo 'email' não pode ser nulo e deve ser único
    private String email; // Campo para armazenar o email do usuário

    @Column(nullable = false) // Define que o campo 'senha' não pode ser nulo
    private String senha; // Campo para armazenar a senha do usuário
}
