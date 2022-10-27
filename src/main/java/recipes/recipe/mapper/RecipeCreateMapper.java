package recipes.recipe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import recipes.recipe.Recipe;
import recipes.recipe.model.RecipeCreate;


@Mapper(componentModel = "spring")
public abstract class RecipeCreateMapper {

	@Mappings({@Mapping(target = "id", ignore = true), @Mapping(target = "uniqueId", ignore = true), @Mapping(target = "date", ignore = true),})
	public abstract Recipe toRecipe(RecipeCreate recipeCreate);

}

