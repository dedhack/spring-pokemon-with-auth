package izhar.springframework.springpokemonwithauth.repository;

import izhar.springframework.springpokemonwithauth.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRepository, Integer> {

    // to check user
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
