package recipes.recipe.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import recipes.user.model.UserRead;

import java.util.List;

@Data
public class RecipeRead {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private String date;
	private String name;
	private String description;
	private String category;
	private List<String> ingredients;
	private List<String> directions;
	private UserRead author;
}
