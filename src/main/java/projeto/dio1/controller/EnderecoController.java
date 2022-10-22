package projeto.dio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.dio1.model.Endereco;
import projeto.dio1.service.impl.EnderecoServiceImpl;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    EnderecoServiceImpl enderecoService;

    @GetMapping
    public String inicial() {
        return "ENDERECO";
    }


    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getEndereco(@PathVariable String cep) {
        Endereco endereco = enderecoService.consultaCep(cep);
        return ResponseEntity.ok(endereco);
    }

}
