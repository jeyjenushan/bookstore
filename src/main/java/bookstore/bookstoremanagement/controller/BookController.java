package bookstore.bookstoremanagement.controller;


import bookstore.bookstoremanagement.entity.Book;
import bookstore.bookstoremanagement.entity.MyBookList;
import bookstore.bookstoremanagement.service.BookService;
import bookstore.bookstoremanagement.service.MyBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookService myBookService;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "book_register";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
      List<Book> list=bookService.getAllBooks();

      return new ModelAndView("available_books","book",list);
    }
    @GetMapping("/my_books")
    public String getmyBooks(Model model){
        List<MyBookList>list=myBookService.getAllMyBooks();
        System.out.println(list);
        model.addAttribute("book",list);
        return "my_books";
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        bookService.save(b);
        return "redirect:/available_books";

    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book b=bookService.getBookById(id);
       MyBookList myBookList=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());

        myBookService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable int id,Model model){
        Book b=bookService.getBookById(id);
        //controller to view we sent this
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deletebook/{id}")
    public String deletebook(@PathVariable int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
