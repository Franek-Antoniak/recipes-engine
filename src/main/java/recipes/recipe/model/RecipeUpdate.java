package recipes.recipe.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class RecipeUpdate {
    // TODO: 28.06.2021 You can change size of Strings to
    //  @Size(min = 1, max = 255) because of the VARCHAR(255) in H2

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Description cannot be blank")
    private String description;
    @NotBlank(message = "Category cannot be blank")
    private String category;
    @NotEmpty(message = "Ingredients should contain at least 1 element")
    private List<String> ingredients;
    @NotEmpty(message = "Directions should contain at least 1 element")
    private List<String> directions;
}
