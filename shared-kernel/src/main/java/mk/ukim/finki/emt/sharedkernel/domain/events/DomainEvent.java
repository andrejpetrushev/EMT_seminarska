package mk.ukim.finki.emt.sharedkernel.domain.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.time.Instant;

@Getter
public class DomainEvent {

    //topic - naslov za event
    private String topic;

    //datum koga se pojavil nekoj event
    private Instant occurredOn;

    //konstruktor so argument
    public DomainEvent(String topic) {
        this.occurredOn = Instant.now();
        this.topic = topic;
    }

    //metod koj pravi serijalizacija na event vo json string
    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();     //za transmisija preku kafka message broker
        String output = null;
        try {
            output = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {

        }
        return output;
    }

    //vid na get metod koj go vrakja soodvetniot topic
    public String topic() {
        return topic;
    }

    //metod koj pravi deserijalizacija, od json vo originalna klasa
    public static <E extends DomainEvent> E fromJson(String json, Class<E> eventClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json,eventClass);
    }
}

