package recipes.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import recipes.recipe.Recipe;
import recipes.user.details.role.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private boolean enabled = true;
	@Fetch(value = FetchMode.SUBSELECT)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<UserRole> roles = new ArrayList<>();
	@OneToMany(
			mappedBy = "author",
			cascade = CascadeType.REMOVE
	)
	@ToString.Exclude
	private List<Recipe> recipes = new ArrayList<>();

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
			return false;
		}
		User user = (User) o;
		return id != null && Objects.equals(id, user.id);
	}
}
