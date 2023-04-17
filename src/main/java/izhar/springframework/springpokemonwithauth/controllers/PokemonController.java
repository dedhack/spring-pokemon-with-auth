package izhar.springframework.springpokemonwithauth.controllers;

import izhar.springframework.springpokemonwithauth.dto.PokemonDto;
import izhar.springframework.springpokemonwithauth.models.Pokemon;
import izhar.springframework.springpokemonwithauth.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/")
public class PokemonController {


    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    // for tutorial purposes, we don't do this for production
    @GetMapping("pokemon")
    public ResponseEntity<List<PokemonDto>> getPokemon(){
        return new ResponseEntity<>(pokemonService.getAllPokemon(), HttpStatus.OK);
    }

    @GetMapping("pokemon/{id}")
    public Pokemon pokemonDetail(@PathVariable int id){
        return new Pokemon(id, "Squirtle", "Water");
    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto){
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonDto), HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, @PathVariable("id") int pokemonId){
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());
        return ResponseEntity.ok(pokemon);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId){
        System.out.println(pokemonId);
        return ResponseEntity.ok("Pokemon deleted successfully");
    }

}
