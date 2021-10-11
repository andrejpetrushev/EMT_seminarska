package mk.ukim.finki.emt.rolesstaffmanagement.infra;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//implementacija na publisher na nastani
@Service
//@AllArgsConstructor
public class DomainEventPublisherImpl implements DomainEventPublisher {

    //message broker - kafka
    private final KafkaTemplate<String,String> kafkaTemplate;

    //konstruktor so argumenti
    public DomainEventPublisherImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //publish metod za publikuvanje/isprakjanje na nekoj nastan
    @Override
    public void publish(DomainEvent event) {
        this.kafkaTemplate.send(event.topic(),event.toJson());
    }
}
