package uz.ulugbek.bookshopproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.bookshopproject.domain.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Review.ReviewId> {
}
