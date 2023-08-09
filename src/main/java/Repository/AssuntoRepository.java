package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.AssuntoModel;
import Model.LivroModel;

public interface AssuntoRepository extends JpaRepository<AssuntoModel, Long>{


}
