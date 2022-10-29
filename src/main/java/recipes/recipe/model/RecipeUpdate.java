package recipes.recipe.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RecipeUpdate {
	//  28.06.2021 You can change size of Strings to
	//  @Size(min = 1, max = 255) because of the VARCHAR(255) in H2

	private String name;
	private String description;
	private String category;
	private List<String> ingredients;
	private List<String> directions;
}
