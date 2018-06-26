package ru.prestu.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.prestu.spring.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
