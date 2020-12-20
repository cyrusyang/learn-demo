package org.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import java.util.Map;
import java.util.Set;

public class PurchasePassDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("采购申请通过==》");
        Map<String, Object> variables = delegateExecution.getVariables();
        Set<String> strings = variables.keySet();
        for (String string : strings) {
            System.out.println(string+":" + variables.get(string));
        }
    }
}
