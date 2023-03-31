package uz.ulugbek.bookshopproject;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.ulugbek.bookshopproject.domain.Review;
import uz.ulugbek.bookshopproject.domain.enums.Rating;
import uz.ulugbek.bookshopproject.repositories.ReviewRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookShopApplicationTests {

	@Autowired
	private ReviewRepository reviewRepository;

	@Test
	@Disabled
	void contextLoads() {
	}

	@Test
	@Order(1)
	public void testCreateReview() {
		Review review = new Review();
		review.setBookId(1L);
		review.setUserId(1L);

		review.setComment("Test review");
		review.setRating(Rating.FIVE);
		review.setPostedAt(LocalDateTime.now());

		reviewRepository.save(review);

	}

	@Test
	@Order(2)
	public void testLoadReview() {

		Review review = reviewRepository.findById(new Review.ReviewId(1L,1L)).orElseThrow();
		assertEquals(1L, review.getBookId());
		assertEquals(1L, review.getUserId());

		assertEquals("Test review", review.getComment());
	}

}
