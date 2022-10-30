package recipes.recipe.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RecipeRead {
	@ApiModelProperty(
			notes = "Name of the recipe",
			example = "Pancakes",
			required = true
	)
	private String name;
	@ApiModelProperty(
			notes = "Description of the recipe",
			example = "Delicious pancakes with strawberries",
			required = true
	)
	private String description;
	@ApiModelProperty(
			notes = "category of the recipe",
			example = "Breakfast",
			required = true
	)
	private String category;
	@ApiModelProperty(
			notes = "List of ingredients",
			example = "[\"flour\", \"eggs\", \"milk\", \"strawberries\", " + "\"sugar\", \"butter\"]",
			required = true
	)
	private List<String> ingredients;
	@ApiModelProperty(
			notes = "List of steps",
			example = "[\"Mix flour, eggs, milk, sugar and butter\", \"Heat the " + "pan\", \"Pour the batter\", \"Flip the pancake\", \"Serve with strawberries\"]",
			required = true
	)
	private List<String> directions;
}
