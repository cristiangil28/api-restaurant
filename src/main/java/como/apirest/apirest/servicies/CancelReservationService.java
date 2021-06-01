package como.apirest.apirest.servicies;

import como.apirest.apirest.exceptions.BookingException;

public interface CancelReservationService {
	public String deleteReservation(String locator) throws BookingException;
}
