package como.apirest.apirest.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import como.apirest.apirest.dtos.ErrorDto;

public class InternalServerErrorExecption extends BookingException{
	
	private static final long serialVersionUID = 1L;

	public InternalServerErrorExecption(String code , String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
	
	public InternalServerErrorExecption(String code , String message,ErrorDto data) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
	}
}
