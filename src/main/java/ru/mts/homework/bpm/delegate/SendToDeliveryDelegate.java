package ru.mts.homework.bpm.delegate;

import lombok.Data;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.mts.homework.model.DeliveryRequest;
import ru.mts.homework.model.ServiceRequest;

@Data
@Component
public class SendToDeliveryDelegate implements JavaDelegate {

    private KafkaTemplate<String, ServiceRequest> kafkaTemplate;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        DeliveryRequest deliveryRequest = new DeliveryRequest();
        kafkaTemplate.send("delivery-request", deliveryRequest);
    }
}
