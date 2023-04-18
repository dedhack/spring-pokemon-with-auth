package izhar.springframework.springpokemonwithauth.service;

import izhar.springframework.springpokemonwithauth.dto.PokemonDto;
import izhar.springframework.springpokemonwithauth.dto.PokemonResponse;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
    PokemonResponse getAllPokemon(int pageNo, int pageSize);

    PokemonDto getPokemonById(int id);

    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemonId(int id);
}
