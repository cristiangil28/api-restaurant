package como.apirest.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import como.apirest.apirest.exceptions.BookingException;
import como.apirest.apirest.jsons.RestaurantRest;
import como.apirest.apirest.responses.BookingResponse;
import como.apirest.apirest.servicies.RestaurantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/restaurant/{restaurantId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
		return new BookingResponse<>("sucess", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurants", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<List<RestaurantRest>> getRestaurants() throws BookingException {
		return new BookingResponse<>("Sucess", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurants());
	}
}
