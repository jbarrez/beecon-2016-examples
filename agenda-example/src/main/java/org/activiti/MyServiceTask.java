package org.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

public class MyServiceTask implements JavaDelegate {

  private Expression parameter;
  
  public void execute(DelegateExecution execution) {
      System.out.println("Hello from " + parameter.getValue(execution));
  }

}
