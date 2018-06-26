package ru.prestu.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.prestu.spring.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
