package recipes.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipes.recipe.Recipe;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

	Optional<Recipe> findTopByOrderByIdDesc();

	List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);

	List<Recipe> findAllByNameContainingIgnoreCaseOrderByDateDesc(String name);

}
