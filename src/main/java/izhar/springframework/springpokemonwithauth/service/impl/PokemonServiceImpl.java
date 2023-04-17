package izhar.springframework.springpokemonwithauth.service.impl;

import izhar.springframework.springpokemonwithauth.dto.PokemonDto;
import izhar.springframework.springpokemonwithauth.models.Pokemon;
import izhar.springframework.springpokemonwithauth.repository.PokemonRepository;
import izhar.springframework.springpokemonwithauth.service.PokemonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {

    private PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokemonDto pokemonResponse = new PokemonDto();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());
        return pokemonResponse;

    }

    @Override
    public List<PokemonDto> getAllPokemon() {
        List<Pokemon> pokemon = pokemonRepository.findAll(); // what we retrieve is the Pokemon obj and not a rare case that requires pokemonDto
        // Map returns a new list, unlike a for loop with no return
        return pokemon.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
    }

    // Mapper
    private PokemonDto mapToDto(Pokemon pokemon){
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());
        return pokemonDto;
    }

    private Pokemon mapToEntity(PokemonDto pokemonDto){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());
        return pokemon;
    }

}
