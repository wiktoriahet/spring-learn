package pl.hetman.wiktoria.spring.learn.app.bookstore.web.spring_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest { //jakbym otwierała stronę przez przeglądarkę
    //To do that, you could start the application
    // and listen for a connection (as it would do in production)
    // and then send an HTTP request and assert the response.

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void bookControllerHttpRequest() {
//        try {
            this.restTemplate.getForObject(
                    "http://localhost:" + port + "/books?id=-99",
                    String.class).contains("bookstore");
//            System.out.println("#### NO EXCEPTION!!!");
//            Assertions.assertTrue(true);
//        } catch (Exception e) {
//            System.out.println("#### EXCEPTION!!!");
//            Assertions.assertTrue(false);
//        }
    }

}
