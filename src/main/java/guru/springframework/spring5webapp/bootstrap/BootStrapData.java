package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development", "354654654");



        Publisher pub_one = new Publisher("4IT", "Bulevardul Magheru", "Bucharest", "Romania", "6546546");
        Publisher pub_two = new Publisher("4Greatness", "Central Park, NY", "New York", "U.S.A.", "8975354");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(pub_one);


        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(pub_two);

        authorRepository.save(eric);
        publisherRepository.save(pub_one);
        bookRepository.save(ddd);
        authorRepository.save(rod);
        publisherRepository.save(pub_two);
        bookRepository.save(noEJB);



        System.out.println("----- Started in Bootstrap -----");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());

 

    }
}
