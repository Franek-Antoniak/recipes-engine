package recipes.recipe.controller.annotation;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ApiOperation("Get a recipe by ID")
@ResponseStatus(HttpStatus.OK)
@ApiResponses(
		value = {@ApiResponse(
				responseCode = "200",
				description = "Recipe found and returned"
		), @ApiResponse(
				responseCode = "403",
				description = "Authorization failed",
				content = @Content(
						schema = @Schema(implementation = String.class),
						mediaType = "*/*",
						examples = {@ExampleObject(value = "User is not authorized to see this recipe")}
				)
		), @ApiResponse(
				responseCode = "404",
				description = "Recipe not found"
		)}
)
@Retention(RUNTIME)
@Target({METHOD, ANNOTATION_TYPE})
public @interface GetRecipeByIdApiAnnotation {
}