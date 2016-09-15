import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;


public class Main4 {
  
  public static void main(String[] args) {
    
    // Deploy a process definition in v6. New instances will be execution on the new engine
    // Show ACT_RE_PROC_DEF and ACT_RU_EXECUTION (different structure)
    execute6Logic3();
  }
  
  private static void execute6Logic3() {
    ProcessEngine processEngine = new StandaloneProcessEngineConfiguration()
      .setActiviti5CompatibilityEnabled(true) 
      .setJdbcUrl("jdbc:postgresql://localhost:5432/demo")
      .setJdbcUsername("alfresco")
      .setJdbcPassword("alfresco")
      .setJdbcDriver("org.postgresql.Driver")
      .setDatabaseSchemaUpdate("true")
      .buildProcessEngine();
    
    RepositoryService repositoryService = processEngine.getRepositoryService();
    
    repositoryService.createDeployment()
        .addClasspathResource("myprocess.bpmn20.xml")
        .deploy();
    
    RuntimeService runtimeService = processEngine.getRuntimeService();
    HistoryService historyService = processEngine.getHistoryService();
    
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
    
    long countFinished = historyService.createHistoricProcessInstanceQuery()
          .processDefinitionId(processInstance.getProcessDefinitionId())
          .finished()
          .count();
    
    long countRunning = historyService.createHistoricProcessInstanceQuery()
        .processDefinitionId(processInstance.getProcessDefinitionId())
        .unfinished()
        .count();
    
    System.out.println("Number of process instances " + countRunning);
    System.out.println("Number of processes finished = " + countFinished);
    
  }

}
