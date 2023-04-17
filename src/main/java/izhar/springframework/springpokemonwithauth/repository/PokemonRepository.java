package izhar.springframework.springpokemonwithauth.repository;

import izhar.springframework.springpokemonwithauth.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
