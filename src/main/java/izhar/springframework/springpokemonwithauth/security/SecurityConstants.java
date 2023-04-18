package izhar.springframework.springpokemonwithauth.security;

public class SecurityConstants {
    public static final long JWT_EXPIRATION = 70000;
    public static final String JWT_SECRET = "secret"; // TODO: not supposed to store here where it is accessible to others
}
