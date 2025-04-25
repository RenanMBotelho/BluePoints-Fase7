package br.com.bluepoints.controller;

import br.com.bluepoints.model.Usuario;
import br.com.bluepoints.security.service.TokenService;
import br.com.bluepoints.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Usuario usuario){

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        String token = tokenService.createToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario gravar(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.gravar(usuario);
        return novoUsuario;
    }

}
