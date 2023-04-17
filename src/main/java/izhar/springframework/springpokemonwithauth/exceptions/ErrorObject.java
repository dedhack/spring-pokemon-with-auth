package izhar.springframework.springpokemonwithauth.exceptions;

import lombok.Data;
import java.util.Date;

@Data
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private Date timestamp;
}
