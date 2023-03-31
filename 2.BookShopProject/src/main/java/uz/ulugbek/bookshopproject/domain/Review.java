package uz.ulugbek.bookshopproject.domain;


import jakarta.persistence.*;
import lombok.*;
import uz.ulugbek.bookshopproject.domain.enums.Rating;

import java.io.Serializable;
import java.time.LocalDateTime;


/*
* Example for ID class
*   Rules:
*       1. all primary key attributes annotated with @Id
*       2. IdClass as "shadow" of primary key attributes. It means the class must have same name and type
*
* */

@Entity
@Table(name = "reviews")
@Getter
@Setter
@IdClass(Review.ReviewId .class)
@EqualsAndHashCode
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long userId;

    @Id
    @Column(name = "book_id", updatable = false, nullable = false)
    private Long bookId;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "posted_at")
    private LocalDateTime postedAt;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    public static class ReviewId implements Serializable {

        private static final long serialVersionUID = 1L;

        private Long userId;
        private Long bookId;

    }

}
