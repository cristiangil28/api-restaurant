package como.apirest.apirest.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import como.apirest.apirest.dtos.ErrorDto;

public class NotFoundException extends BookingException{

	private static final long serialVersionUID = 1L;

	public NotFoundException(String code , String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
	}
	
	public NotFoundException(String code , String message,ErrorDto data) {
		super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
	}
}
