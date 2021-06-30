package recipes.recipe;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Recipe {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonIgnore
    private UUID uniqueId;
    private String name;
    private String description;
    private String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime date;
    /**
     * FIXME:28.06.2021
     * LazyCollection(LazyCollectionOption.FALSE) is an another solution
     * If you won't feel tired, you can read something about JPA and ORM problems there
     * https://stackoverflow.com/questions/4334970
     */
    @Fetch(value = FetchMode.SUBSELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> ingredients;
    @Fetch(value = FetchMode.SUBSELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> directions;

    @PrePersist
    private void onCreate() {
        uniqueId = UUID.randomUUID();
        date = LocalDateTime.now();
    }

    /**
     * Static class represents ID of Recipe as Object
     */
    @Data
    @AllArgsConstructor
    public static class ID {
        private long id;
    }
}

