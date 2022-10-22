package projeto.dio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.dio1.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
