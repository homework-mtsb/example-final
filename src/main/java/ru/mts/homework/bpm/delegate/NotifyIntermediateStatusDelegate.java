package ru.mts.homework.bpm.delegate;

import lombok.extern.java.Log;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.mts.homework.bpm.ConstValues;

import java.util.logging.Level;

@Log
@Component
public class NotifyIntermediateStatusDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.log(Level.INFO, "executed NotifyIntermediateStatusDelegate: {}", execution);
        String status = (String)execution.getVariableLocal(ConstValues.STATUS);
        //todo send status
    }
}
