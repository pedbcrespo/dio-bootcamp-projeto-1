package projeto.dio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import projeto.dio1.model.Cliente;
import projeto.dio1.service.impl.ClienteServiceImpl;
import projeto.dio1.service.impl.EnderecoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    EnderecoServiceImpl enderecoService;

    @Autowired
    ClienteServiceImpl clienteService;


    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return clienteService.getAll();
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        return clienteService.getById(id);
    }

    @GetMapping("/update-cliente/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente atualizacao) {
        return clienteService.update(id, atualizacao);
    }

    @GetMapping("/salva-cliente")
    public ResponseEntity<Cliente> salvaCliente(@RequestBody Cliente novoCliente) {
        String cep = novoCliente.getCepEndereco();
        novoCliente.setEndereco(enderecoService.consultaCep(cep));
        return clienteService.save(novoCliente);
    }

    @GetMapping("/deleta-cliente/{id}")
    public ResponseEntity<Cliente> deletaCliente(@PathVariable Long id) {
        return clienteService.delete(id);
    }

}
