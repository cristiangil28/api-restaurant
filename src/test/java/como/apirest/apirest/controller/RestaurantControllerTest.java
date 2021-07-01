package como.apirest.apirest.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import como.apirest.apirest.controllers.RestaurantController;
import como.apirest.apirest.exceptions.BookingException;
import como.apirest.apirest.jsons.RestaurantRest;
import como.apirest.apirest.responses.BookingResponse;
import como.apirest.apirest.servicies.RestaurantService;

public class RestaurantControllerTest {

	private static final Long RESTAURANT_ID = 1L;
	private static final String SUCCESS_STATUS = "Sucess";
	private static final String SUCCESS_CODE = "200 OK";
	private static final String OK = "OK";
	private static final RestaurantRest RESTAURANT_REST = new RestaurantRest();
	private static final List TURN_LIST = new ArrayList<>();
	public static final List<RestaurantRest> RESTAURANT_REST_LIST = new ArrayList<>();
	@Mock
	RestaurantService restaurantService;

	@InjectMocks
	RestaurantController restaurantController;

	@Before
	public void init() throws BookingException {
		MockitoAnnotations.openMocks(this);
		RESTAURANT_REST.setName("Burger");
		RESTAURANT_REST.setDescription("Todo tipo de hamburguesa");
		RESTAURANT_REST.setAddress("Av. santander");
		RESTAURANT_REST.setId(RESTAURANT_ID);
		RESTAURANT_REST.setImage("www.image.com");
		RESTAURANT_REST.setTurn(TURN_LIST);

		Mockito.when(restaurantService.getRestaurantById(RESTAURANT_ID)).thenReturn(RESTAURANT_REST);
	}

	@Test
	public void getRestaurantByIdTest() throws BookingException {
		final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantById(RESTAURANT_ID);

		assertEquals(response.getStatus(), SUCCESS_STATUS);
		assertEquals(response.getCode(), SUCCESS_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), RESTAURANT_REST);
	}

	@Test
	public void getRestaurantsTest() throws BookingException {

		final BookingResponse<List<RestaurantRest>> response = restaurantController.getRestaurants();

		assertEquals(response.getStatus(), SUCCESS_STATUS);
		assertEquals(response.getCode(), SUCCESS_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), RESTAURANT_REST_LIST);
	}
}
