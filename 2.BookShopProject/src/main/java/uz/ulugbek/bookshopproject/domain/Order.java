package uz.ulugbek.bookshopproject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "posted_at")
    private LocalDateTime orderedAt;

    @ManyToOne
    private Book book;

    public Order(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }
}
