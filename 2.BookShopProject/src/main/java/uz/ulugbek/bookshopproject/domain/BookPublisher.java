package uz.ulugbek.bookshopproject.domain;

import jakarta.persistence.*;
import lombok.*;
import uz.ulugbek.bookshopproject.domain.enums.Format;

import java.io.Serializable;

@Entity
@Table(name = "book_publishers")
@Data
public class BookPublisher implements Serializable {

    @EmbeddedId
    private BookPublisherId id = new BookPublisherId();

    @ManyToOne
    @JoinColumn(name = "book_id")
    @MapsId(value = "bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @MapsId(value = "publisherId")
    private Publisher publisher;

    @Enumerated(value = EnumType.STRING)
    private Format format;

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BookPublisherId implements Serializable {

        private Long bookId;

        private Long publisherId;

    }
}
