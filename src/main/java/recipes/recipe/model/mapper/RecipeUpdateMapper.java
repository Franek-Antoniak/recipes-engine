package recipes.recipe.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import recipes.recipe.Recipe;
import recipes.recipe.model.RecipeUpdate;


@Mapper(componentModel = "spring")
public abstract class RecipeUpdateMapper {
	@Mappings(
			{@Mapping(
					target = "id",
					ignore = true
			), @Mapping(
					target = "uniqueId",
					ignore = true
			), @Mapping(
					target = "date",
					ignore = true
			), @Mapping(
					target = "author",
					ignore = true
			),}
	)
	public abstract void updateRecipe(RecipeUpdate recipeUpdate, @MappingTarget Recipe recipe);
}

