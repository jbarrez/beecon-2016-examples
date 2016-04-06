import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.DeploymentProperties;
import org.activiti.engine.runtime.ProcessInstance;


public class Main3 {
  
  public static void main(String[] args) {
    
    // Deploy a process definition in v5
	// Show ACT_RE_PROCDEF
    execute6Logic2();
    
  }

  private static void execute6Logic() {
    ProcessEngine processEngine = new StandaloneProcessEngineConfiguration()
      .setActiviti5CompatibilityEnabled(true)
      .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=UTF-8")
      .setJdbcUsername("alfresco")
      .setJdbcPassword("alfresco")
      .setJdbcDriver("com.mysql.jdbc.Driver")
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
  

	private static void execute6Logic2() {
		ProcessEngine processEngine = new StandaloneProcessEngineConfiguration()
				.setActiviti5CompatibilityEnabled(true) 
				.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/demo?characterEncoding=UTF-8")
				.setJdbcUsername("alfresco")
				.setJdbcPassword("alfresco")
				.setJdbcDriver("com.mysql.jdbc.Driver")
				.setDatabaseSchemaUpdate("true")
				.buildProcessEngine();

		RepositoryService repositoryService = processEngine.getRepositoryService();

		repositoryService.createDeployment().addClasspathResource("myprocess.bpmn20.xml")
				.deploymentProperty(DeploymentProperties.DEPLOY_AS_ACTIVITI5_PROCESS_DEFINITION, true)
				.deploy();

	}



}
