package izhar.springframework.springpokemonwithauth.service;

import izhar.springframework.springpokemonwithauth.dto.PokemonDto;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
    List<PokemonDto> getAllPokemon();

    PokemonDto getPokemonById(int id);

    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemonId(int id);
}
