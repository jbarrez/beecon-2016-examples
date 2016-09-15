import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;


public class Main {
  
  public static void main(String[] args) {
    ProcessEngine processEngine = new StandaloneInMemProcessEngineConfiguration().buildProcessEngine();
    
    RepositoryService repositoryService = processEngine.getRepositoryService();
    RuntimeService runtimeService = processEngine.getRuntimeService();
    HistoryService historyService = processEngine.getHistoryService();
    TaskService taskService = processEngine.getTaskService();
    
    Deployment deployment = repositoryService.createDeployment()
      .addClasspathResource("myprocess.bpmn20.xml")
      .deploy();
    
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
    
    Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
    System.out.println(task.getName() + " needs to be done by " + task.getAssignee());
    taskService.complete(task.getId());
    
    long count = historyService.createHistoricProcessInstanceQuery()
          .processDefinitionId(processInstance.getProcessDefinitionId())
          .finished()
          .count();
    System.out.println("Number of processes finished = " + count);
  }

}
