package ru.prestu.spring.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.prestu.spring.model.Author;
import ru.prestu.spring.model.Book;
import ru.prestu.spring.model.Publisher;
import ru.prestu.spring.repositories.AuthorRepository;
import ru.prestu.spring.repositories.BookRepository;
import ru.prestu.spring.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher1 = new Publisher();
        publisher1.setName("foo");
        publisher1.setAddress("12th Street, LA");
        publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("bar");
        publisher2.setAddress("13th Street, NY");
        publisherRepository.save(publisher2);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2 );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

}
