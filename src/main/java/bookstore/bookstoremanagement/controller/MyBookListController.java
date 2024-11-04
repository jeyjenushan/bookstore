package bookstore.bookstoremanagement.controller;

import bookstore.bookstoremanagement.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {
    @Autowired
    private MyBookService myBookService;
@RequestMapping("/deleteMyList/{id}")
    public  String deleteMyList(@PathVariable int id){
    myBookService.deleteById(id);
    return "redirect:/my_books";
    }

}
