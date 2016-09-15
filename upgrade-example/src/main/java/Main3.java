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

	private static void execute6Logic2() {
		ProcessEngine processEngine = new StandaloneProcessEngineConfiguration()
				.setActiviti5CompatibilityEnabled(true) 
				.setJdbcUrl("jdbc:postgresql://localhost:5432/demo")
			    .setJdbcUsername("alfresco")
			    .setJdbcPassword("alfresco")
			    .setJdbcDriver("org.postgresql.Driver")
				.setDatabaseSchemaUpdate("true")
				.buildProcessEngine();

		RepositoryService repositoryService = processEngine.getRepositoryService();

		repositoryService.createDeployment().addClasspathResource("myprocess.bpmn20.xml")
				.deploymentProperty(DeploymentProperties.DEPLOY_AS_ACTIVITI5_PROCESS_DEFINITION, true)
				.deploy();

	}



}
