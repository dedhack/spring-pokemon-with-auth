package izhar.springframework.springpokemonwithauth.dto;

import lombok.Data;

@Data
public class AuthResponseDto {

    private String accessToken;
    private String tokenType = "Bearer "; // TODO: why is this necessary to assign value to the tokenType

    public AuthResponseDto(String accessToken){
        this.accessToken = accessToken;
    }
}
