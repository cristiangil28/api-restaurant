package como.apirest.apirest.servicies;

import como.apirest.apirest.exceptions.BookingException;
import como.apirest.apirest.jsons.RestaurantRest;

public interface RestaurantService {
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;
}
