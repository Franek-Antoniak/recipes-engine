package recipes.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import recipes.recipe.Recipe;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
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
	private List<Recipe> recipes = new ArrayList<>();


	@PrePersist
	private void onCreate() {
		// Enabling account
		enabled = true;
	}
}
