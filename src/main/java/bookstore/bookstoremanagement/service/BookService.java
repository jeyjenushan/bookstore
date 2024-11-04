package bookstore.bookstoremanagement.service;

import bookstore.bookstoremanagement.entity.Book;
import bookstore.bookstoremanagement.repository.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private Bookrepository bookrepository;
    public void save(Book b){
        bookrepository.save(b);

    }
    public List<Book> getAllBooks(){
        return bookrepository.findAll();
    }
    public Book getBookById(int id){
        return bookrepository.findById(id).get();
    }
    public void deleteById(int id){
        bookrepository.deleteById(id);
    }

}
