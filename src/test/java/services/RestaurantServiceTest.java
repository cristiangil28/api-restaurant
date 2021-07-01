package services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import como.apirest.apirest.entities.Board;
import como.apirest.apirest.entities.Reservation;
import como.apirest.apirest.entities.Restaurant;
import como.apirest.apirest.entities.Turn;
import como.apirest.apirest.exceptions.BookingException;
import como.apirest.apirest.jsons.RestaurantRest;
import como.apirest.apirest.repositories.RestaurantRepository;
import como.apirest.apirest.servicies.implementation.RestaurantServiceImpl;

public class RestaurantServiceTest {
	
	private static final Long RESTAURANT_ID = 1L;
	public static final Restaurant RESTAURANT = new Restaurant();
	private static final List<Turn> TURN_LIST = new ArrayList<>();
	private static final List<Board> BOARD_LIST = new ArrayList<>();
	private static final List<Reservation> RESERVATION_LIST = new ArrayList<>();
	
	@Mock
	RestaurantRepository restaurantRepository;
	
	@InjectMocks
	RestaurantServiceImpl restaurantService;
	
	@Before
	public void init() throws BookingException {
		MockitoAnnotations.openMocks(this);
		RESTAURANT.setName("Burger");
		RESTAURANT.setDescription("Todo tipo de hamburguesa");
		RESTAURANT.setAddress("Av. santander");
		RESTAURANT.setId(RESTAURANT_ID);
		RESTAURANT.setImage("www.image.com");
		RESTAURANT.setTurns(TURN_LIST);
		RESTAURANT.setBoards(BOARD_LIST);
		RESTAURANT.setReservations(RESERVATION_LIST);
	}
	
	@Test
	public void getRestaurantByIdTest() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.of(RESTAURANT));
		restaurantService.getRestaurantById(RESTAURANT_ID);
	}
	@Test (expected = BookingException.class)
	public void getRestaurantByIdErrorTest() throws BookingException {
		Mockito.when(restaurantRepository.findById(RESTAURANT_ID)).thenReturn(Optional.empty());
		restaurantService.getRestaurantById(RESTAURANT_ID);
		fail();
	}
	
	@Test
	public void getRestaurantsTest() throws BookingException {
		final Restaurant restaurant = new Restaurant();
		Mockito.when(restaurantRepository.findAll()).thenReturn(Arrays.asList(restaurant));
		final List <RestaurantRest> response = restaurantService.getRestaurants();
		
		assertNull(response);
		assertFalse(response.isEmpty());
		assertEquals(response.size(), 1);
	}
	
}
