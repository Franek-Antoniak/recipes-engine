package recipes.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import recipes.user.controller.swagger.RegisterNewUserApiAnnotation;
import recipes.user.exception.UserAlreadyExistAuthenticationException;
import recipes.user.facade.UserFacade;
import recipes.user.model.UserCreate;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/user")
public class UserController {
	private final UserFacade userFacade;

	@PostMapping("/register")
	@RegisterNewUserApiAnnotation
	public ResponseEntity<String> registerNewUser(@Valid @RequestBody UserCreate userCreate) {
		userFacade.registerNewUser(userCreate);
		return ResponseEntity.status(HttpStatus.CREATED)
		                     .body("User registered successfully");
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> userDetailsValidationFail(MethodArgumentNotValidException e) {
		StringBuilder stringBuilder = new StringBuilder();
		for (ObjectError error : e.getBindingResult().getAllErrors()) {
			stringBuilder.append(error.getDefaultMessage())
			             .append("\n");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                     .body(stringBuilder.toString());
	}

	@ExceptionHandler(UserAlreadyExistAuthenticationException.class)
	public ResponseEntity<String> emailAlreadyExists(Exception e) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
		                     .body(e.getMessage());
	}
}
