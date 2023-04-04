package uz.ulugbek.bookshopproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.bookshopproject.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
