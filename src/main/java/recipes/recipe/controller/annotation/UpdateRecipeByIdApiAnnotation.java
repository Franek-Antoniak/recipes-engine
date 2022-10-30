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

@ApiOperation(value = "Update recipe by id")
@ResponseStatus(HttpStatus.NO_CONTENT)
@ApiResponses(
		value = {@ApiResponse(
				responseCode = "204",
				description = "Recipe Updated successfully"
		), @ApiResponse(
				responseCode = "403",
				description = "Authorization failed",
				content = @Content(
						schema = @Schema(implementation = String.class),
						mediaType = "*/*",
						examples = {@ExampleObject(value = "User is not authorized to update this recipe")}
				)
		), @ApiResponse(
				responseCode = "404",
				description = "Recipe not found"
		)}
)
@Retention(RUNTIME)
@Target({METHOD, ANNOTATION_TYPE})
public @interface UpdateRecipeByIdApiAnnotation {
}
