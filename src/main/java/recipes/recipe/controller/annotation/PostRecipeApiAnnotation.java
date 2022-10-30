package recipes.recipe.controller.annotation;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import recipes.recipe.Recipe;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ApiOperation(value = "Create a new recipe")
@ResponseStatus(HttpStatus.CREATED)
@ApiResponses(
		value = {@ApiResponse(
				responseCode = "201",
				description = "Recipe created successfully",
				content = @Content(schema = @Schema(implementation = Recipe.ID.class))
		), @ApiResponse(
				responseCode = "400",
				description = "Validation error",
				content = @Content(
						schema = @Schema(implementation = String.class),
						mediaType = "*/*",
						examples = {@ExampleObject(value = "Category cannot be blank")}
				)
		)}
)
@Retention(RUNTIME)
@Target({METHOD, ANNOTATION_TYPE})
public @interface PostRecipeApiAnnotation {

}