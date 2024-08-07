package ru.mts.homework.bpm.delegate;

import lombok.extern.java.Log;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.mts.homework.bpm.ConstValues;

import java.util.logging.Level;

@Log
@Component
public class CheckAvailableDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.log(Level.INFO,"executed CheckAvailableDelegate: {}", execution);
        boolean value = false;        //todo add call for storage service
        execution.setVariableLocal(ConstValues.AVAILABLE, value);
        if (value) {
            execution.setVariableLocal(ConstValues.STATUS, "ORDER_RESERVED");
        }
    }
}
