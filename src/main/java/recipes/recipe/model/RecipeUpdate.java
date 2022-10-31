package recipes.recipe.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class RecipeUpdate {
	@ApiModelProperty(
			notes = "Name of the recipe",
			example = "Pancakes"
	)
	private String name;
	@ApiModelProperty(
			notes = "Description of the recipe",
			example = "Delicious pancakes with strawberries"
	)
	private String description;
	@ApiModelProperty(
			notes = "category of the recipe",
			example = "Breakfast"
	)
	private String category;
	@ApiModelProperty(
			notes = "List of ingredients",
			example = "[\"flour\", \"eggs\", \"milk\", \"strawberries\", " + "\"sugar\", \"butter\"]"
	)
	private List<String> ingredients;
	@ApiModelProperty(
			notes = "List of steps",
			example = "[\"Mix flour, eggs, milk, sugar and butter\", \"Heat the " + "pan\", \"Pour the batter\", \"Flip the pancake\", \"Serve with strawberries\"]"
	)
	private List<String> directions;
}
