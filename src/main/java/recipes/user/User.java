package recipes.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
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
@NoArgsConstructor
public class User {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	@JsonIgnore
	private String password;
	private boolean enabled;
	@Fetch(value = FetchMode.SUBSELECT)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<UserRole> roles = new ArrayList<>();
	@OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
	@ToString.Exclude
	private List<Recipe> recipes = new ArrayList<>();


	@PrePersist
	private void onCreate() {
		// Enabling account
		enabled = true;
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

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
