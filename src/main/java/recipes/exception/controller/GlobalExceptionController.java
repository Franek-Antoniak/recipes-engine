package recipes.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import recipes.user.exception.UserAuthorizationException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> userDetailsValidationFail(MethodArgumentNotValidException e) {
		StringBuilder stringBuilder = new StringBuilder();
		for (ObjectError error : e.getBindingResult()
		                          .getAllErrors()) {
			stringBuilder.append(error.getDefaultMessage())
			             .append("\n");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                     .body(stringBuilder.toString());
	}

	@ResponseStatus(
			value = HttpStatus.FORBIDDEN,
			reason = "You don't have permission to access this resource"
	)
	@ExceptionHandler(UserAuthorizationException.class)
	public ResponseEntity<String> permissionToRecipeDenied(UserAuthorizationException e) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
		                     .body(e.getMessage());
	}
}
