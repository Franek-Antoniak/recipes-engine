package recipes.recipe.controller.annotation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ResponseStatus(HttpStatus.NO_CONTENT)
@ApiResponses(
		value = {@ApiResponse(
				responseCode = "204",
				description = "Recipe deleted successfully"
		), @ApiResponse(
				responseCode = "403",
				description = "User is not authorized to delete this recipe"
		)}
)
@Retention(RUNTIME)
@Target({METHOD, ANNOTATION_TYPE})
public @interface DeleteRecipeByIdApiAnnotation {
}