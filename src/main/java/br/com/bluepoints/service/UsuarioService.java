package br.com.bluepoints.service;

import br.com.bluepoints.model.Usuario;
import br.com.bluepoints.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario gravar(Usuario usuario){

        String encondedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setSenha(encondedPassword);

        return usuarioRepository.save(usuario);
    }
}
