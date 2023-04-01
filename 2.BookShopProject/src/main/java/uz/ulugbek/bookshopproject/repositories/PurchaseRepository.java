package uz.ulugbek.bookshopproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.bookshopproject.domain.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Purchase.PurchaseId> {
}
