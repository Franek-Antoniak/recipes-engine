package recipes.recipe.model.mapper;

import org.mapstruct.*;
import recipes.recipe.Recipe;
import recipes.recipe.model.RecipeUpdate;

import java.time.LocalDateTime;


@Mapper(componentModel = "spring")
public abstract class RecipeUpdateMapper {
	@BeanMapping(nullValuePropertyMappingStrategy =
			NullValuePropertyMappingStrategy.IGNORE)
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
			)}
	)
	public abstract void updateRecipe(RecipeUpdate recipeUpdate, @MappingTarget Recipe recipe);
	@AfterMapping
	protected void setToCurrentDate(@MappingTarget Recipe recipe) {
		recipe.setDate(LocalDateTime.now());
	}
}

