package pl.hetman.wiktoria.spring.learn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.controller.BookWebController;

@SpringBootTest
class SpringLearnApplicationTests {

	@Autowired
	private BookWebController bookWebController;

	@Test
	void contextLoads() throws Exception {
//		assertThat(bookController).isNotNull();
		Assertions.assertNotNull(bookWebController, "bookController is null");
	}
}
