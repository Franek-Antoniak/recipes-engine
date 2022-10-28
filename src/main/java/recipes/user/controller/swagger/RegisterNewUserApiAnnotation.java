package recipes.user.controller.swagger;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ResponseStatus(HttpStatus.CREATED)
@ApiResponses(value = {
		@ApiResponse(responseCode = "201", description = "User created"),
		@ApiResponse(responseCode = "400", description = "User details are not valid"),
		@ApiResponse(responseCode = "409", description = "Email in use"),
})
@Retention(RUNTIME)
@Target({METHOD, ANNOTATION_TYPE})
public @interface RegisterNewUserApiAnnotation {

}
