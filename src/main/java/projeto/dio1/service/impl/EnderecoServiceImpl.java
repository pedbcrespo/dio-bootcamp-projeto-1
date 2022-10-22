package projeto.dio1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import projeto.dio1.model.Endereco;
import projeto.dio1.repository.EnderecoRepository;
import projeto.dio1.service.EnderecoService;

import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public Endereco consultaCep(String cep) {
        if(cep == null || cep.isBlank()) {
            return null;
        }
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(cep);
        Endereco endereco = enderecoOptional.orElseGet(()->null);
        if(endereco == null) {
            String viaCepUrl = "https://viacep.com.br/ws/".concat(cep).concat("/json/");
            RestTemplate restTemplate = new RestTemplate();
            endereco = restTemplate.getForObject(viaCepUrl, Endereco.class);
        }
        return endereco;
    }
}
