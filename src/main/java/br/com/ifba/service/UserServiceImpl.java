package br.com.ifba.service;

import br.com.ifba.dto.UserDTO;
import br.com.ifba.exception.UserNotFoundException;
import br.com.ifba.model.User;
import br.com.ifba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName()); // Usa o getter de UserDTO
        user.setEmail(userDTO.getEmail()); // Usa o getter de UserDTO
        user.setPassword(userDTO.getPassword()); // Usa o getter de UserDTO
        User savedUser = userRepository.save(user);
        return mapToDTO(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return mapToDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        user.setName(userDTO.getName()); // Usa o getter de UserDTO
        user.setEmail(userDTO.getEmail()); // Usa o getter de UserDTO
        user.setPassword(userDTO.getPassword()); // Usa o getter de UserDTO
        User updatedUser = userRepository.save(user);
        return mapToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    private UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId()); // Usa o getter de User
        userDTO.setName(user.getName()); // Usa o getter de User
        userDTO.setEmail(user.getEmail()); // Usa o getter de User
        userDTO.setPassword(user.getPassword()); // Usa o getter de User
        return userDTO;
    }
}