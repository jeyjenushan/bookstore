package bookstore.bookstoremanagement.service;

import bookstore.bookstoremanagement.entity.MyBookList;
import bookstore.bookstoremanagement.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepository myBookRepository;

    public void saveMyBooks(MyBookList myBookList){
        myBookRepository.save(myBookList);
    }
    public List<MyBookList> getAllMyBooks(){
        return myBookRepository.findAll();
    }
    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }

}
