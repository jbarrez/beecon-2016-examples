import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.runtime.ProcessInstance;


public class Main2 {
  
  public static void main(String[] args) {
    
    // Change version in pom.xml to 6
    // Show ACT_RE_PROC_DEF
	// Show ACT_RU_EXEC
    // Process instances are started in v5 mode
    execute6Logic();
    
  }

  private static void execute6Logic() {
    ProcessEngine processEngine = new StandaloneProcessEngineConfiguration()
      .setActiviti5CompatibilityEnabled(true)
      .setJdbcUrl("jdbc:postgresql://localhost:5432/demo")
      .setJdbcUsername("alfresco")
      .setJdbcPassword("alfresco")
      .setJdbcDriver("org.postgresql.Driver")
      .setDatabaseSchemaUpdate("true")
      .buildProcessEngine();
    
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
