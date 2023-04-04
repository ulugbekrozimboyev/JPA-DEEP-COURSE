package uz.ulugbek.bookshopproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.bookshopproject.domain.BookPublisher;

@Repository
public interface BookPublisherRepository extends CrudRepository<BookPublisher, Long> {
}
