package com.newssystem.lab;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newssystem.lab.model.News;
import com.newssystem.lab.repository.NewsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lukasz on 2016-03-14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NewsSystemApplication.class)
public class NewsControllerTest {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private NewsRepository newsRepository;

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testCreateNews() throws JsonProcessingException,IOException {

        Map<String,Object> requestBody = new HashMap<>();
        requestBody.put("title", "tytul");
        requestBody.put("text","tresc");
        requestBody.put("data", "21.23.2012");
        HttpHeaders reqestHeaders = new HttpHeaders();
        reqestHeaders.setContentType(MediaType.APPLICATION_JSON);

        //Creating http entity object with request body and headers
        HttpEntity<String> httpEntity =
                new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody), reqestHeaders);

        //Invoking the API
        Map<String, Object> apiResponse =
                restTemplate.postForObject("http://localhost:8080/api/news/saveNews",
                        httpEntity, Map.class, Collections.EMPTY_MAP);

        assertNotNull(apiResponse);

        //Asserting the response of the API.
        String message = apiResponse.get("message").toString();
        assertEquals("News created successfully", message);
        String bookId = ((Map<String, Object>)apiResponse.get("news")).get("id").toString();

        assertNotNull(bookId);

        //Fetching the Book details directly from the DB to verify the API succeeded
        News bookFromDb = newsRepository.findOne(bookId);
        assertEquals("tresc", bookFromDb.getText());
        assertEquals("21.23.2012", bookFromDb.getData());
        assertEquals("tytul", bookFromDb.getTitle());


    }

}
