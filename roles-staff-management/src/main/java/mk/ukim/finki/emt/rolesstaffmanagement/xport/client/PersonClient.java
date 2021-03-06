package mk.ukim.finki.emt.rolesstaffmanagement.xport.client;

import mk.ukim.finki.emt.rolesstaffmanagement.domain.valueobjects.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

//PersonClient - restful service koj prevzema podatoci od nadvoreshen resurs - person-catalog
@Service
public class PersonClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    //konstruktor so argumenti, se kreira serverUrl za isprakjanje na podatoci i template za rest povici
    public PersonClient(@Value("${app.person-catalog.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    //metod koj vrakja URI - Uniform Resource Identifier
    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    //metod koj vrakja lista od objekti od tip Person
    public List<Person> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/people").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Person>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
