package recipes.recipe.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
public class RecipeCreate {
	@ApiModelProperty(
			notes = "Name of the recipe",
			example = "Pancakes",
			required = true
	)
	@NotBlank(message = "Name cannot be blank")
	private String name;
	@ApiModelProperty(
			notes = "Description of the recipe",
			example = "Delicious pancakes with strawberries",
			required = true
	)
	@NotBlank(message = "Description cannot be blank")
	private String description;
	@ApiModelProperty(
			notes = "category of the recipe",
			example = "Breakfast",
			required = true
	)
	@NotBlank(message = "Category cannot be blank")
	private String category;
	@ApiModelProperty(
			notes = "List of ingredients",
			example = "[\"flour\", \"eggs\", \"milk\", \"strawberries\", " + "\"sugar\", \"butter\"]",
			required = true
	)
	@NotEmpty(message = "Ingredients should contain at least 1 element")
	private List<String> ingredients;
	@ApiModelProperty(
			notes = "List of steps",
			example = "[\"Mix flour, eggs, milk, sugar and butter\", \"Heat the " + "pan\", \"Pour the batter\", \"Flip the pancake\", \"Serve with strawberries\"]",
			required = true
	)
	@NotEmpty(message = "Directions should contain at least 1 element")
	private List<String> directions;
}
