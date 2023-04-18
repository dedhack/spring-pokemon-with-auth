package izhar.springframework.springpokemonwithauth.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ReviewDto {

    private int id;
    private String title;
    private String content;
    private int stars;
}
