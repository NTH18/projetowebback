package br.com.ifba.entity; // Pacote onde a classe está localizada

// Importa as anotações do Jakarta Persistence e Lombok, além de classes adicionais
import jakarta.persistence.*; // Para trabalhar com JPA (Java Persistence API)
import lombok.Getter; // Para gerar o método getter automaticamente
import lombok.Setter; // Para gerar o método setter automaticamente
import java.io.Serializable; // Para garantir que a classe seja serializável

@Getter // Lombok irá gerar o método getter para todos os campos da classe
@Setter // Lombok irá gerar o método setter para todos os campos da classe
@MappedSuperclass // Indica que esta classe será a classe base para outras entidades persistentes
public abstract class PersistenceEntity implements Serializable {
    @Id // Define que o campo 'id' é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.AUTO) // Especifica que o valor do 'id' será gerado automaticamente
    private Long id; // Campo para armazenar o ID da entidade, tipo Long
}
