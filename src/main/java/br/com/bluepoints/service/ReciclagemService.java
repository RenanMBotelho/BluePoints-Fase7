package br.com.bluepoints.service;

import br.com.bluepoints.dto.ReciclagemCadastroDto;
import br.com.bluepoints.dto.ReciclagemExibirDto;
import br.com.bluepoints.exception.ReciclagemNaoEncontradaException;
import br.com.bluepoints.model.Reciclagem;
import br.com.bluepoints.repository.ReciclagemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReciclagemService {

    @Autowired
    private ReciclagemRepository reciclagemRepository;

    public ReciclagemExibirDto gravar(ReciclagemCadastroDto reciclagemCadastroDto){

        Reciclagem reciclagem = new Reciclagem();
        BeanUtils.copyProperties(reciclagemCadastroDto, reciclagem);

        return new ReciclagemExibirDto(reciclagemRepository.save(reciclagem));
    }

    public ReciclagemExibirDto buscarPorId(Long id){

        Optional<Reciclagem> reciclagemOptional = reciclagemRepository.findById(id);

        if(reciclagemOptional.isPresent()){
            return new ReciclagemExibirDto(reciclagemOptional.get());
        } else {
            throw new ReciclagemNaoEncontradaException("Reciclagem não encontrada!");
        }
    }

    /*public ReciclagemExibirDto buscarPorUsuario(Long usuario){

        Optional<Reciclagem> reciclagemOptional = reciclagemRepository.findByUsuario(usuario);

        if(reciclagemOptional.isPresent()){
            return new ReciclagemExibirDto(reciclagemOptional.get());
        } else {
            throw new UsuarioSemReciclagemException("Usuário sem reciclagens!");
        }
    }*/

    public List<Reciclagem> listarTodasReciclagens(){
        return reciclagemRepository.findAll();
    }

    public void excluir(Long id) {

        Optional<Reciclagem> reciclagemOptional = reciclagemRepository.findById(id);

        if(reciclagemOptional.isPresent()){
            reciclagemRepository.delete(reciclagemOptional.get());
        } else {
            throw new ReciclagemNaoEncontradaException("Reciclagem não encontrada para exclusão!");
        }
    }

    public Reciclagem atualizar(Reciclagem reciclagem){

        Optional<Reciclagem> reciclagemOptional = reciclagemRepository.findById(reciclagem.getId());

        if(reciclagemOptional.isPresent()){
            return reciclagemRepository.save(reciclagem);
        } else {
            throw new ReciclagemNaoEncontradaException("Reciclagem não encontrada para atualizar!");
        }
    }

}
