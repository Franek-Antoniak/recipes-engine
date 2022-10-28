package recipes.recipe.mapper;

import org.mapstruct.Mapper;
import recipes.recipe.Recipe;
import recipes.recipe.model.RecipeRead;

@Mapper(componentModel = "spring")
public abstract class RecipeReadMapper {
	public abstract RecipeRead toRecipeRead(Recipe recipe);
}