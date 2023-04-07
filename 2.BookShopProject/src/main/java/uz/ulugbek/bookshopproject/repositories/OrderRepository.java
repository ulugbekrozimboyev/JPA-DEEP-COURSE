package uz.ulugbek.bookshopproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.bookshopproject.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
