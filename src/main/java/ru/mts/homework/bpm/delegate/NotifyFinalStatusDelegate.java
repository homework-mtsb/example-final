package ru.mts.homework.bpm.delegate;

import lombok.extern.java.Log;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.mts.homework.bpm.ConstValues;

import java.util.logging.Level;

@Log
@Component
public class NotifyFinalStatusDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.log(Level.INFO, "executed NotifyFinalStatusDelegate: {}", execution);
        String status = (String)execution.getVariableLocal(ConstValues.STATUS);
        switch (status) {
            case "COMPLETED": break;
            case "DELIVERY_FAILED": break;
            case "NOT_ENOUGH_AVAILABLE": break;
            case "ASSAMBLEY_FAILED": break;
        }
        //todo send status and additional info
    }
}
