package recipes.recipe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import recipes.recipe.Recipe;
import recipes.recipe.model.RecipeUpdate;


@Mapper(componentModel = "spring")
public abstract class RecipeUpdateMapper {
    public abstract void updateRecipe(RecipeUpdate recipeUpdate, @MappingTarget Recipe recipe);
}

