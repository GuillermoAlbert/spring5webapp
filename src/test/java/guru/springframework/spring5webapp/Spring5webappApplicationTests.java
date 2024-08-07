package guru.springframework.spring5webapp;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring5webappApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	public void testBookRepository() {
		long count = bookRepository.count();

		assertThat(count).isGreaterThan(0);
	}

	@Test
	public void contextLoads() {
	}

	@Test
    public void testJpaTestSplice() {
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("Domain Driven Design12", "12312", "RandomHouse1"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

}
