package como.apirest.apirest.servicies.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import como.apirest.apirest.exceptions.BookingException;
import como.apirest.apirest.exceptions.InternalServerErrorExecption;
import como.apirest.apirest.exceptions.NotFoundException;
import como.apirest.apirest.repositories.ReservationRepository;
import como.apirest.apirest.servicies.CancelReservationService;

@Service
public class CancelReservationServiceImpl implements CancelReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);
	
	public String deleteReservation(String locator) throws BookingException {
		reservationRepository.findByLocator(locator)
				.orElseThrow(() -> new NotFoundException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));
		try {
			reservationRepository.deleteByLocator(locator);
		} catch (Exception e) {
			LOGGER.error("Internal server error,",e);
			throw new InternalServerErrorExecption("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		return "Locator removed";
	}

}
