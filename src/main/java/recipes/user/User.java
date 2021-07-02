package recipes.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    // FIXME: 02.07.2021 You can make that by creating new Enum with roles, and adding new table with
    //  oneToMany relationShip to set static roles with static behaviour
    private String roles;
    // FIXME: 02.07.2021 check if it is user or User
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Recipe> recipes = new ArrayList<>();


    @PrePersist
    private void onCreate() {
        // Enabling account
        enabled = true;
        // If there is no role, assign a User role
        if(roles == null)
            roles = "ROLE_USER";
    }
}
