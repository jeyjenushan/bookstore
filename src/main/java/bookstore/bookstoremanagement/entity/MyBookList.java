package bookstore.bookstoremanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="mybook")
public class MyBookList {
    @Id
    private int id;
    private String name;
    private String author;
    private String price;
}
