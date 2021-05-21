package como.apirest.apirest.servicies.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import como.apirest.apirest.entities.Restaurant;
import como.apirest.apirest.exceptions.BookingException;
import como.apirest.apirest.exceptions.NotFoundException;
import como.apirest.apirest.jsons.RestaurantRest;
import como.apirest.apirest.repositories.RestaurantRepository;
import como.apirest.apirest.servicies.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	public static final ModelMapper modelMapper = new ModelMapper();
	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
		// model mapper sirve paa enviar datos de una clase a otra
		
		return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
		
	}
	private Restaurant getRestaurantEntity(Long restaurantId)throws BookingException{
		return restaurantRepository.findById(restaurantId).orElseThrow(()-> new NotFoundException("SNOT-404-1","RESTAURANT_NOT_FOUND"));
	}
}
