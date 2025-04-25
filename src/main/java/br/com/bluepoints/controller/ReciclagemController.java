package br.com.bluepoints.controller;

import br.com.bluepoints.dto.ReciclagemCadastroDto;
import br.com.bluepoints.dto.ReciclagemExibirDto;
import br.com.bluepoints.model.Reciclagem;
import br.com.bluepoints.service.ReciclagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReciclagemController {

    @Autowired
    private ReciclagemService service;

    @PostMapping("/reciclagem")
    @ResponseStatus(HttpStatus.CREATED)
    public ReciclagemExibirDto gravar(@RequestBody @Valid ReciclagemCadastroDto reciclagemCadastroDto){
        return service.gravar(reciclagemCadastroDto);
    }

    @GetMapping("/reciclagem")
    @ResponseStatus(HttpStatus.OK)
    public List<Reciclagem> listarTodasReciclagens(){
        return service.listarTodasReciclagens();
    }

    /*@GetMapping("/reciclagem/{usuario}")
    @ResponseStatus(HttpStatus.OK)
    public ReciclagemExibirDto buscarPorUsuario(@PathVariable Long usuario){
        return service.buscarPorUsuario(usuario);
    }*/

    @DeleteMapping("/reciclagem/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        service.excluir(id);
    }

    @PutMapping("/reciclagem")
    @ResponseStatus(HttpStatus.OK)
    public Reciclagem atualizar(@RequestBody Reciclagem reciclagem){
        return service.atualizar(reciclagem);
    }

}
