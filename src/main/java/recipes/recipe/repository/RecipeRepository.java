package recipes.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import recipes.recipe.Recipe;
import recipes.recipe.Recipe_;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>, JpaSpecificationExecutor<Recipe> {
	Optional<Recipe> findTopByOrderByIdDesc();

	List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);

	List<Recipe> findAllByNameContainingIgnoreCaseOrderByDateDesc(String name);

	default List<Recipe> findAllByIngredientsInOrderByDateDesc(List<String> ingredients) {
		return findAll((root, query, criteriaBuilder) -> {
			Predicate predicate = criteriaBuilder.conjunction();
			for (String ingredient : ingredients) {
				predicate = criteriaBuilder.and(
						predicate, criteriaBuilder.isMember(ingredient, root.get(Recipe_.ingredients)));
			}
			query.orderBy(criteriaBuilder.desc(root.get(Recipe_.date)));
			return predicate;
		});
	}

	default List<Recipe> findAllByCategoryIgnoreCaseAndIngredientsIgnoreCaseInOrderByDateDesc(
			String category, List<String> ingredients
	                                                                                         ) {
		return findAll((root, query, criteriaBuilder) -> {
			Predicate predicate = criteriaBuilder.equal(root.get(Recipe_.category), category);
			for (String ingredient : ingredients) {
				predicate = criteriaBuilder.and(
						predicate, criteriaBuilder.isMember(ingredient, root.get(Recipe_.ingredients)));
			}
			query.orderBy(criteriaBuilder.desc(root.get(Recipe_.date)));
			return predicate;
		});
	}
}
