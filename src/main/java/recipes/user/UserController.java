package recipes.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.user.exception.UserAlreadyExistAuthenticationException;
import recipes.user.model.UserCreate;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class UserController {
    private final UserFacade userFacade;

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@Valid @RequestBody UserCreate userCreate) {
        return userFacade.registerNewUser(userCreate);
    }

    // Exceptions Handlers

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, // 401 - BAD_REQUEST
            reason = "The email, that you provided already exists in DataBase")
    @ExceptionHandler(UserAlreadyExistAuthenticationException.class)
    public void emailAlreadyExists() {
    }

}
