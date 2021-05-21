package como.apirest.apirest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import como.apirest.apirest.entities.*;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long>{
	Optional<Turn> findById(Long id);
}
