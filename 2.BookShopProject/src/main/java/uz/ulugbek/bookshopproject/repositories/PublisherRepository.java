package uz.ulugbek.bookshopproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.bookshopproject.domain.Publisher;
import uz.ulugbek.bookshopproject.domain.enums.Format;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    @Query("SELECT p FROM Publisher p join p.bookPublishers bp join bp.book b WHERE bp.format = :format and b.id = :bookId")
    Publisher findByBookFormatAndBookId(Format format, Long bookId);
}
