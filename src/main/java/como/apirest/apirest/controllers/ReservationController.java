package como.apirest.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import como.apirest.apirest.exceptions.BookingException;
import como.apirest.apirest.jsons.CreateReservationRest;
import como.apirest.apirest.responses.BookingResponse;
import como.apirest.apirest.servicies.ReservationService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> createReservation(@RequestBody @Validated CreateReservationRest createReservationRest)
			throws BookingException {
		return new BookingResponse<>("Sucess",String.valueOf(HttpStatus.OK), "OK", reservationService.crateReservation(createReservationRest));
	}
}
