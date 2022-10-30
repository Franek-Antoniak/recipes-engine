package recipes.user.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.user.controller.annotation.RegisterNewUserApiAnnotation;
import recipes.user.exception.UserAlreadyExistsException;
import recipes.user.model.UserCreate;
import recipes.user.service.facade.UserFacade;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/user")
@Validated
public class UserController {
	private final UserFacade userFacade;

	@PostMapping("/register")
	@RegisterNewUserApiAnnotation
	public ResponseEntity<Void> registerNewUser(
			@ApiParam("Registration details") @RequestBody @Valid UserCreate userCreate
	                                           ) {
		userFacade.registerNewUser(userCreate);
		return ResponseEntity.status(HttpStatus.CREATED)
		                     .build();
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> emailAlreadyExists(Exception e) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
		                     .body(e.getMessage());
	}
}
