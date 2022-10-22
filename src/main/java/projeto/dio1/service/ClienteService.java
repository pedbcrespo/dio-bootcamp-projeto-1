package projeto.dio1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import projeto.dio1.model.Cliente;

import java.util.List;

@Service
public interface ClienteService {

    ResponseEntity<List<Cliente>> getAll();
    ResponseEntity<Cliente> getById(Long id);
    ResponseEntity<Cliente> getByDesc(Cliente descCliente);
    ResponseEntity<Cliente> update(Long id, Cliente atualizacao);
    ResponseEntity<Cliente> save(Cliente novoCliente);
    ResponseEntity<Cliente> delete(Long id);
}
