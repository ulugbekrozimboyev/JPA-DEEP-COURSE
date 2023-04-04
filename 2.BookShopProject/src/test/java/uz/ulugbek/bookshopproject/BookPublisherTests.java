package uz.ulugbek.bookshopproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.ulugbek.bookshopproject.domain.Book;
import uz.ulugbek.bookshopproject.domain.BookPublisher;
import uz.ulugbek.bookshopproject.domain.Publisher;
import uz.ulugbek.bookshopproject.domain.enums.Format;
import uz.ulugbek.bookshopproject.repositories.BookPublisherRepository;
import uz.ulugbek.bookshopproject.repositories.BookRepository;
import uz.ulugbek.bookshopproject.repositories.PublisherRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookPublisherTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookPublisherRepository bookPublisherRepository;

    @Test
    public void testCreateAndReadBookPublisher() {
        // save book
        Long bookId = saveBook();

        // save publisher
        Long publisherId = savePublisher();

        // get book and publisher
        Book book = bookRepository.findById(bookId).orElseThrow();
        Publisher publisher = publisherRepository.findById(publisherId).orElseThrow();

        // save book publisher
        saveBookPublisher(book, publisher);

        // check
        Publisher publisher1 = publisherRepository.findByBookFormatAndBookId(Format.PAPER, bookId);
        assertEquals(publisher.getId(), publisher1.getId());

    }

    private void saveBookPublisher(Book book, Publisher publisher) {
        BookPublisher bookPublisher = new BookPublisher();
        bookPublisher.setBook(book);
        bookPublisher.setPublisher(publisher);
        bookPublisher.setFormat(Format.PAPER);
        bookPublisherRepository.save(bookPublisher);
    }

    private Long savePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Test publisher");
        publisherRepository.save(publisher);
        return publisher.getId();
    }

    private Long saveBook() {
        Book book = new Book();
        book.setTitle("Test book");
        book.setIsbn("23423423423");
        book.setDescription("test book test book desc");
        book.setPublishedDate(LocalDateTime.now());
        bookRepository.save(book);

        return book.getId();
    }

}
