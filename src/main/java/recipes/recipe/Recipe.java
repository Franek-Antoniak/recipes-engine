package recipes.recipe;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import recipes.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RecipeID")
	private Long id;
	private UUID uniqueId = UUID.randomUUID();
	private String name;
	private String description;
	private String category;
	private LocalDateTime date = LocalDateTime.now();
	@ManyToOne
	@JoinColumn(name = "UserId")
	private User author;
	@Fetch(value = FetchMode.SUBSELECT)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> ingredients;
	@Fetch(value = FetchMode.SUBSELECT)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> directions;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		Recipe recipe = (Recipe) o;
		return id != null && Objects.equals(id, recipe.id);
	}

	public ID getRecipeID() {
		return new ID(this.id);
	}

	/**
	 * Static class represents ID of Recipe as Object
	 */
	@Value
	@ApiModel(description = "ID of Recipe")
	public static class ID {
		Long id;
	}
}

