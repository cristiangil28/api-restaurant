package como.apirest.apirest.servicies;

import como.apirest.apirest.exceptions.BookingException;
import como.apirest.apirest.jsons.CreateReservationRest;
import como.apirest.apirest.jsons.ReservationRest;

public interface ReservationService {
	ReservationRest getReservation(Long reservartionId) throws BookingException;
	
	String crateReservation(CreateReservationRest createReservationRest) throws BookingException;
}
