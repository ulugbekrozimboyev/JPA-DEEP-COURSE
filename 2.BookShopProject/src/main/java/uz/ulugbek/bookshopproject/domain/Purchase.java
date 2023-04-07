package uz.ulugbek.bookshopproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
* Example for EmbeddedId class
*   Roles:
*       1. Both class must implement Serializable interface
*       2. Use EmbeddedId annotation primary key attribute
*       3. Use Embeddable annotation for primary key class
 * */

@Entity
@Table(name = "purchases")
@Getter
@Setter
@EqualsAndHashCode
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PurchaseId id;

    @Column(name = "count")
    private Integer count;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "posted_at")
    private LocalDateTime orderedAt;

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class PurchaseId implements Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name = "user_id", updatable = false, nullable = false)
        private Long userId;

        @Column(name = "book_id", updatable = false, nullable = false)
        private Long bookId;
    }
}
