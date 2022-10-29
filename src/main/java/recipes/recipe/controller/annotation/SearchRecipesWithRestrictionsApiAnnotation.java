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

@ResponseStatus(HttpStatus.OK)
@ApiResponses(
		value = {@ApiResponse(
				responseCode = "200",
				description = "Recipes found and returned"
		), @ApiResponse(
				responseCode = "204",
				description = "No recipes found"
		), @ApiResponse(
				responseCode = "400",
				description = "There should be no more than 2 arguments and no less than 1 argument"
		)}
)
@Retention(RUNTIME)
@Target({METHOD, ANNOTATION_TYPE})
public @interface SearchRecipesWithRestrictionsApiAnnotation {
}
