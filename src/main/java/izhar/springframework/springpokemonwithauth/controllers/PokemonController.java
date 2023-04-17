package izhar.springframework.springpokemonwithauth.controllers;

import izhar.springframework.springpokemonwithauth.models.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/")
public class PokemonController {

    // for tutorial purposes, we don't do this for production
    @GetMapping("pokemon")
    public ResponseEntity<List<Pokemon>> getPokemon(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1, "Squirtle", "Water"));
        pokemons.add(new Pokemon(2, "Pikachu", "Electric"));
        pokemons.add(new Pokemon(3, "Charmander", "Fire"));
        return ResponseEntity.ok(pokemons);
    }

//    @GetMapping("pokemon/{id}")
//    public Pokemon pokemonDetail(@PathVariable int id){
//        return new Pokemon(id, )
//    }

    @PostMapping("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getType());
        return new ResponseEntity<>(pokemon, HttpStatus.CREATED);
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
