package uz.ulugbek.bookshopproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ulugbek.bookshopproject.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
