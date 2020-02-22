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

        Publisher pub_one = new Publisher("4IT");
        Publisher pub_two = new Publisher("4Greatness");
        Publisher pub_three = new Publisher("4Science");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.getPublishers().add(pub_one);
        ddd.getPublishers().add(pub_three);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.getPublishers().add(pub_two);
        noEJB.getPublishers().add(pub_three);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub_one);
        publisherRepository.save(pub_two);
        publisherRepository.save(pub_three);





        System.out.println("----- Started in Bootstrap -----");
        System.out.println("Number of Books: " + bookRepository.count());

    }
}
