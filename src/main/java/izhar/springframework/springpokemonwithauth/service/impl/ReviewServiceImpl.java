package izhar.springframework.springpokemonwithauth.service.impl;

import izhar.springframework.springpokemonwithauth.dto.ReviewDto;
import izhar.springframework.springpokemonwithauth.exceptions.PokemonNotFoundException;
import izhar.springframework.springpokemonwithauth.models.Pokemon;
import izhar.springframework.springpokemonwithauth.models.Review;
import izhar.springframework.springpokemonwithauth.repository.PokemonRepository;
import izhar.springframework.springpokemonwithauth.repository.ReviewRepository;
import izhar.springframework.springpokemonwithauth.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    // autowire the necessary repositories
    private ReviewRepository reviewRepository;
    private PokemonRepository pokemonRepository;

     @Autowired
     public ReviewServiceImpl(ReviewRepository reviewRepository, PokemonRepository pokemonRepository){
         this.reviewRepository = reviewRepository;
         this.pokemonRepository = pokemonRepository;
     }

    @Override
    public ReviewDto createReview(int pokemonId, ReviewDto reviewDto) {
        Review review = mapToEntity(reviewDto);

        // set the Pokemon for Review
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()->new PokemonNotFoundException("Pokemon not found"));
        review.setPokemon(pokemon);
        Review newReview = reviewRepository.save(review);

        return mapToDto(newReview);

    }




    @Override
    public List<ReviewDto> getReviewsByPokemonId(int id) {
        return null;
    }

    // Mappers
    private ReviewDto mapToDto(Review review) {
         ReviewDto reviewDto = new ReviewDto();
         reviewDto.setId(review.getId());
         reviewDto.setTitle(review.getTitle());
         reviewDto.setContent(review.getContent());
         reviewDto.setStars(review.getStars());
         return reviewDto;
    }
    private Review mapToEntity(ReviewDto reviewDto) {
         Review review = new Review();
         review.setTitle(reviewDto.getTitle());
         review.setContent(reviewDto.getContent());
         review.setStars(reviewDto.getStars());
         return review;
    }
}
