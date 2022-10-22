package projeto.dio1.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import projeto.dio1.model.Endereco;

public interface EnderecoService {

    @GetMapping("/cep/json/{cep}")
    Endereco consultaCep(@PathVariable String cep);
}
