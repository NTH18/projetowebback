package br.com.ifba.service;

import br.com.ifba.dao.UsuarioIDao;
import br.com.ifba.dto.UsuarioGetResponseDto;
import br.com.ifba.dto.UsuarioPostRequestDto;
import br.com.ifba.entityuser.Usuario;
import br.com.ifba.mapper.ObjectMapperUtil;
import br.com.ifba.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UsuarioIService {

    private final UsuarioIDao usuarioDAO;

    public UsuarioService(UsuarioIDao usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    @Transactional // Garante que a operação de salvamento é feita em uma transação
    public UsuarioGetResponseDto salvar(UsuarioPostRequestDto usuarioPostRequestDTO) {
        if (usuarioDAO.existsByEmail(usuarioPostRequestDTO.getEmail())) {
            throw new BusinessException("Email já está cadastrado!");
        }

        Usuario usuario = ObjectMapperUtil.convert(usuarioPostRequestDTO, Usuario.class);
        usuario = usuarioDAO.save(usuario);
        return ObjectMapperUtil.convert(usuario, UsuarioGetResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true) // Evita bloqueios no banco para leitura
    public UsuarioGetResponseDto buscarPorId(Long id) {
        return usuarioDAO.findById(id)
                .map(usuario -> ObjectMapperUtil.convert(usuario, UsuarioGetResponseDto.class))
                .orElseThrow(() -> new BusinessException("Usuário não encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioGetResponseDto> listarTodos() {
        return usuarioDAO.findAll().stream()
                .map(usuario -> ObjectMapperUtil.convert(usuario, UsuarioGetResponseDto.class))
                .collect(Collectors.toList());
    }
}
