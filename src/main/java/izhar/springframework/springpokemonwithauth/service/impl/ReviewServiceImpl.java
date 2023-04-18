package izhar.springframework.springpokemonwithauth.service.impl;

import izhar.springframework.springpokemonwithauth.dto.ReviewDto;
import izhar.springframework.springpokemonwithauth.exceptions.PokemonNotFoundException;
import izhar.springframework.springpokemonwithauth.exceptions.ReviewNotFoundException;
import izhar.springframework.springpokemonwithauth.models.Pokemon;
import izhar.springframework.springpokemonwithauth.models.Review;
import izhar.springframework.springpokemonwithauth.repository.PokemonRepository;
import izhar.springframework.springpokemonwithauth.repository.ReviewRepository;
import izhar.springframework.springpokemonwithauth.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()->new PokemonNotFoundException("Pokemon with associated review not found"));
        review.setPokemon(pokemon);
        Review newReview = reviewRepository.save(review);

        return mapToDto(newReview);

    }

    @Override
    public List<ReviewDto> getReviewsByPokemonId(int id) {
        List<Review> reviews = reviewRepository.findByPokemonId(id);

        return reviews.stream().map(review -> mapToDto(review)).collect(Collectors.toList());
    }

    @Override
    public ReviewDto getReviewById(int reviewId, int pokemonId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()-> new PokemonNotFoundException("Pokemon with associated review not found"));

        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new ReviewNotFoundException("Review with associated Pokemon not found"));

        // Not recommended in a production env to use != but supposed to use equals, but it won't work here because it's not a wrapper type
        if(review.getPokemon().getId() != pokemon.getId()){
            throw new ReviewNotFoundException("This review does not belong to a pokemon");
        }

        return mapToDto(review);
    }

    @Override
    public ReviewDto updateReview(int pokemonId, int reviewId, ReviewDto reviewDto) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId).orElseThrow(()-> new PokemonNotFoundException("Pokemon with associated review not found"));

        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new ReviewNotFoundException("Review with associated Pokemon not found"));

        // Not recommended in a production env to use != but supposed to use equals, but it won't work here because it's not a wrapper type
        if(review.getPokemon().getId() != pokemon.getId()){
            throw new ReviewNotFoundException("This review does not belong to a pokemon");
        }

        // the key difference for update is that you need to map it over
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStars(reviewDto.getStars());

        Review updateReview = reviewRepository.save(review); // save and update practically the same
        return mapToDto(updateReview);
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
