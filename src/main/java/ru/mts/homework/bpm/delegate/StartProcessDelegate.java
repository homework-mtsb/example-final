package ru.mts.homework.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.mts.homework.bpm.ConstValues;

@Component
public class StartProcessDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariableLocal(ConstValues.STATUS, "NEW");
    }
}
