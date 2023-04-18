package izhar.springframework.springpokemonwithauth.controllers;


import izhar.springframework.springpokemonwithauth.dto.ReviewDto;
import izhar.springframework.springpokemonwithauth.models.Review;
import izhar.springframework.springpokemonwithauth.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {

    // wire review service class
    private ReviewService reviewService;

    // constructor
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/pokemon/{pokemonId}/review")
    public ResponseEntity<ReviewDto> createReview(
            @PathVariable(value = "pokemonId") int pokemonId,
            @RequestBody ReviewDto reviewDto
            ){
        return new ResponseEntity<ReviewDto>(reviewService.createReview(pokemonId, reviewDto), HttpStatus.CREATED);
    }

    @GetMapping("/pokemon/{pokemonId}/reviews")
    public List<ReviewDto> getReviewsByPokemonId(@PathVariable(value = "pokemonId") int pokemonId){
        return reviewService.getReviewsByPokemonId(pokemonId);
    }

    @GetMapping("/pokemon/{pokemonId}/reviews/{id}")
    public ResponseEntity<ReviewDto> getReviewById(
            @PathVariable(value = "pokemonId") int pokemonId,
            @PathVariable(value ="id" ) int reviewId){
        ReviewDto reviewDto = reviewService.getReviewById(pokemonId, reviewId);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }
}
