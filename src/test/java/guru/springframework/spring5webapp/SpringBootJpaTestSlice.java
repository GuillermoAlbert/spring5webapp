package guru.springframework.spring5webapp;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.spring5webapp.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testJpaTestSplice() {
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("Domain Driven Design12", "12312", "RandomHouse1"));

        long countAfter = bookRepository.count();

        assertThat(countAfter).isEqualTo(countBefore + 1);
    }
}
