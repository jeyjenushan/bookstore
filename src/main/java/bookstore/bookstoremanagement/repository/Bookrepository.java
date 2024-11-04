package bookstore.bookstoremanagement.repository;

import bookstore.bookstoremanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface Bookrepository extends JpaRepository<Book,Integer> {
}
