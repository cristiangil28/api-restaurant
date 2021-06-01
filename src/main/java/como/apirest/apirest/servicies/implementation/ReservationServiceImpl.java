package como.apirest.apirest.servicies.implementation;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import como.apirest.apirest.entities.Reservation;
import como.apirest.apirest.entities.Restaurant;
import como.apirest.apirest.entities.Turn;
import como.apirest.apirest.exceptions.BookingException;
import como.apirest.apirest.exceptions.InternalServerErrorExecption;
import como.apirest.apirest.exceptions.NotFoundException;
import como.apirest.apirest.jsons.CreateReservationRest;
import como.apirest.apirest.jsons.ReservationRest;
import como.apirest.apirest.repositories.ReservationRepository;
import como.apirest.apirest.repositories.RestaurantRepository;
import como.apirest.apirest.repositories.TurnRepository;
import como.apirest.apirest.servicies.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private TurnRepository turnRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;

	public ReservationRest getReservation(Long reservartionId) throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}

	public String crateReservation(CreateReservationRest createReservationRest) throws BookingException {
		final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
				.orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));
		final Turn turn = turnRepository.findById(createReservationRest.getTurnId())
				.orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));
		String locator = generateLocator(restaurantId, createReservationRest);
		final Reservation reservation = new Reservation();
		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restaurantId);
		reservation.setTurn(turn.getName());
		try {
			reservationRepository.save(reservation);
		} catch (Exception e) {
			LOGGER.error("Internal server error,",e);
			throw new InternalServerErrorExecption("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return locator;
	}

	private String generateLocator(Restaurant restaurdanId, CreateReservationRest createReservationRest)
			throws BookingException {
		return restaurdanId.getName() + createReservationRest.getTurnId();
	}
}
