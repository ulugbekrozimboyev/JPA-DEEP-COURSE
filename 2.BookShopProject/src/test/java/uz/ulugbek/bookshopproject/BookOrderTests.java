package uz.ulugbek.bookshopproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.ulugbek.bookshopproject.domain.Book;
import uz.ulugbek.bookshopproject.domain.Order;
import uz.ulugbek.bookshopproject.repositories.BookRepository;
import uz.ulugbek.bookshopproject.repositories.OrderRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookOrderTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @org.junit.jupiter.api.Order(1)
    public void testSaveBookAndOrders() {

        // save a book
        Book book = saveBook();

        // save some orders
        Order order1 = saveOrder();
        Order order2 = saveOrder();
        Order order3 = saveOrder();

        book.getOrders().add(order1);
        book.getOrders().add(order2);
        book.getOrders().add(order3);

        bookRepository.save(book);

        assertEquals(3, book.getOrders().size());

        order1.setBook(book);
        order2.setBook(book);
        order3.setBook(book);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        // get again from DB
        Book bookNew = bookRepository.findById(book.getId()).orElseThrow();
//        assertEquals(3, bookNew.getOrders().size());

//        bookNew.getOrders().remove(order1);
//        bookNew.getOrders().remove(order2);
//        bookNew.getOrders().remove(order3);
//
//        order1.setBook(null);
//        order2.setBook(null);
//        order3.setBook(null);

//        orderRepository.save(order1);
//        orderRepository.save(order2);
//        orderRepository.save(order3);

        bookRepository.delete(bookNew);

    }


    private Book saveBook() {
        Book book = new Book();
        book.setTitle("JPA Cookbook");
        book.setIsbn("098765432");
        book.setDescription("A new Book about JPA");
        book.setPublishedDate(LocalDateTime.now());
        bookRepository.save(book);

        return book;
    }

    private Order saveOrder() {
        Order order = new Order(LocalDateTime.now());
        orderRepository.save(order);

        return order;
    }
}
