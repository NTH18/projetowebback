package br.com.ifba.service;

import br.com.ifba.exception.BusinessException;
import br.com.ifba.entityuser.User;
import br.com.ifba.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import java.util.List;

// Indica que esta classe é um serviço na camada de negócio e será gerenciada pelo Spring
@Service
// Gera um construtor para inicializar os campos final marcados como @NonNull
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public User save(User user) {
        // Chama o método save do UserRepository e retorna o usuário salvo
        return userRepository.save(user);
    }

    // Método para buscar todos os usuários do banco de dados
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    // Implementação do método para excluir um usuário com base no ID
    @Override
    @Transactional
    public void delete(Long id) {
        // Chama o repositório para excluir o usuário pelo ID
        userRepository.deleteById(id);
    }

    // Implementação do método para atualizar um usuário
    @Override
    @Transactional
    public User update(User user) {
        // Chama o repositório para salvar as alterações feitas no usuário
        return userRepository.save(user);
    }

    @Override // Sobrescreve o método da interface ou classe pai
    public User findById(Long id) { // Método para buscar um usuário pelo ID
        return (User) userRepository.findById(id) // Busca o usuário no repositório pelo ID
                .orElseThrow(() -> new BusinessException("Not found User")); // Lança uma exceção caso o usuário não seja encontrado
    }
}