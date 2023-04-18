package izhar.springframework.springpokemonwithauth.repository;

import izhar.springframework.springpokemonwithauth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
