package guru.springframework.spring5webapp.bootstrap;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse");

        System.out.println("Id" + bookDDD.getId());

        Book savedDDD = bookRepository.save(bookDDD);

        System.out.println("Id" + savedDDD.getId());

        Book bookSIA = new Book("Spring In Action", "456", "Oriely");
        Book savedISA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Id: " + book.getId());
            System.out.println("Title: " + book.getTitle());
        });
    }
}
