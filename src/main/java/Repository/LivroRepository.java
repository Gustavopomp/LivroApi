package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.LivroModel;

public interface LivroRepository extends JpaRepository<LivroModel, Long>{

	List<LivroModel> findbyedicao(Integer edicao);

}
