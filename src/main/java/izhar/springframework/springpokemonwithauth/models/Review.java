package izhar.springframework.springpokemonwithauth.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private int stars;

    @ManyToOne(fetch = FetchType.LAZY) // preferable is LAZY LOADING, to save memory and DB
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;
}
