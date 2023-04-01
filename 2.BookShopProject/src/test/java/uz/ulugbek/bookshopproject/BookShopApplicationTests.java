package uz.ulugbek.bookshopproject;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.ulugbek.bookshopproject.domain.Purchase;
import uz.ulugbek.bookshopproject.domain.Review;
import uz.ulugbek.bookshopproject.domain.enums.Rating;
import uz.ulugbek.bookshopproject.repositories.PurchaseRepository;
import uz.ulugbek.bookshopproject.repositories.ReviewRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookShopApplicationTests {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

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

	@Test
	@Order(3)
	public void testCreateOrder() {
		Purchase purchase = new Purchase();

		Purchase.PurchaseId purchaseId = new Purchase.PurchaseId();
		purchaseId.setBookId(1L);
		purchaseId.setUserId(1L);

		purchase.setId(purchaseId);
		purchase.setPrice(new BigDecimal("123.45"));
		purchase.setCount(1);
		purchase.setOrderedAt(LocalDateTime.now());

		purchaseRepository.save(purchase);

	}

	@Test
	@Order(4)
	public void testLoadOrder() {

		Purchase.PurchaseId purchaseId = new Purchase.PurchaseId(1L, 1L);
		Purchase purchase = purchaseRepository.findById(purchaseId).orElseThrow();
		assertEquals(purchaseId, purchase.getId());

		assertEquals(new BigDecimal("123.45"), purchase.getPrice());
	}

}
