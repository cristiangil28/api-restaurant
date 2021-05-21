package como.apirest.apirest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import como.apirest.apirest.entities.*;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{
	Optional<Restaurant> findById(Long id);
	Optional<Restaurant> findByName(String nameRestaurant);
}
