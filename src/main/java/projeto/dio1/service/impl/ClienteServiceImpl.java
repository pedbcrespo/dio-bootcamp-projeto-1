package projeto.dio1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projeto.dio1.controller.EnderecoController;
import projeto.dio1.model.Cliente;
import projeto.dio1.repository.ClienteRepository;
import projeto.dio1.service.ClienteService;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> listaResultado = clienteRepository.findAll();
        return ResponseEntity.ok(listaResultado);
    }

    public ResponseEntity<Cliente> getById(Long id) {
        Optional<Cliente> clienteBuscadoPeloId = clienteRepository.findById(id);
        return ResponseEntity.ok(clienteBuscadoPeloId.get());
    }

    @Override
    public ResponseEntity<Cliente> getByDesc(Cliente descCliente) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING
                );
        Example<Cliente> example = Example.of(descCliente, matcher);
        List<Cliente> listaResultado = clienteRepository.findAll(example);
        return ResponseEntity.ok(listaResultado.get(0));
    }

    @Override
    public ResponseEntity<Cliente> update(Long id, Cliente atualizacao) {
        Cliente clienteBuscado = getById(id).getBody();
        if (clienteBuscado == null) {
            return null;
        }
        return ResponseEntity.ok(atualizacao);
    }

    @Override
    public ResponseEntity<Cliente> save(Cliente novoCliente) {

        Cliente clienteSalvo = clienteRepository.save(novoCliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @Override
    public ResponseEntity<Cliente> delete(Long id) {
        Cliente clienteParaSerRemovido = getById(id).getBody();
        if (clienteParaSerRemovido != null) {
            clienteRepository.delete(clienteParaSerRemovido);
        }
        return ResponseEntity.ok(clienteParaSerRemovido);
    }
}
