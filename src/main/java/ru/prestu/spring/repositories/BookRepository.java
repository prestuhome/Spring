package ru.prestu.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.prestu.spring.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
