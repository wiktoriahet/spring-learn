package pl.hetman.wiktoria.spring.learn.app.bookstore.web.spring_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookWebControllerHttpRequestTest { //jakbym otwierała stronę przez przeglądarkę
    //To do that, you could start the application
    // and listen for a connection (as it would do in production)
    // and then send an HTTP request and assert the response.

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void bookControllerHttpRequest() throws Exception {
        String url = "http://localhost:8080/books";

//        BookModel bookModel = new BookModel();
//        bookModel.setTitle("Title title");
//        bookModel.setPages("230");
//        bookModel.setIsbn(IsbnGenerator.generateIsbn());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String bookModelStringBody = objectMapper.writeValueAsString(bookModel);
//        System.out.println("#### bookModelStringBody: "+ bookModelStringBody);

//        HttpEntity<String> request = new HttpEntity<>(
//                bookModelStringBody, headers);

        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formDataKeyValue = new LinkedMultiValueMap<>();
        formDataKeyValue.add("title", "Super Title!");
        formDataKeyValue.add("pages", "101");

        HttpEntity<MultiValueMap<String, String>> request = new
                HttpEntity<>(formDataKeyValue, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                url, request, String.class);
        System.out.println("#### RESPONSE " + responseEntity);
    }

}

//todo 11,01,2024
// stworzyć nową aplikację na start.spring.io
// stworzyć i zaimplementować warstwy kontroler, serwis, repository, mapper
// dwa modele w aplikacji
