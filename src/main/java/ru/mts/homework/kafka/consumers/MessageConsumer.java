package ru.mts.homework.kafka.consumers;

import lombok.Data;
import org.camunda.bpm.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import ru.mts.homework.bpm.ConstValues;
import ru.mts.homework.model.ServiceResponse;
import ru.mts.homework.model.StartMessage;

import java.util.Map;

@Data
public class MessageConsumer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final RuntimeService runtimeService;


    @KafkaListener(topics = "start-process", groupId = "consumer-1")
    public void startProcess(StartMessage msg) {
        Map<String, Object> variables = Map.of(ConstValues.PRODUCT_CODE, msg.getProductCode(), ConstValues.QUANTITY, msg.getQuantity());

        runtimeService.startProcessInstanceByKey("Sample", msg.getId(), variables);
        logger.info("Recieved {}", msg);
    }

    @KafkaListener(topics = "service-response", groupId = "consumer-1")
    public void consumeResponse(ServiceResponse msg) {
        runtimeService.correlateMessage(msg.getMessageCode(), msg.getId(), msg.getVariables());
    }


}
