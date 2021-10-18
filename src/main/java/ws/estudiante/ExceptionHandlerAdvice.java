package ws.estudiante;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleException(NoSuchElementException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("El elemento solicitado no esta registrado en la base de datos");
	}
}
