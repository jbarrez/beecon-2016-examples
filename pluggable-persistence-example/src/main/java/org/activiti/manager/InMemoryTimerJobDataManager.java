package org.activiti.manager;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.TimerJobQueryImpl;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.PropertyEntity;
import org.activiti.engine.impl.persistence.entity.PropertyEntityImpl;
import org.activiti.engine.impl.persistence.entity.TimerJobEntity;
import org.activiti.engine.impl.persistence.entity.TimerJobEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.PropertyDataManager;
import org.activiti.engine.impl.persistence.entity.data.TimerJobDataManager;
import org.activiti.engine.runtime.Job;

public class InMemoryTimerJobDataManager extends AbstractInMemoryDataManager<TimerJobEntity> implements TimerJobDataManager {

	public InMemoryTimerJobDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	public TimerJobEntity create() {
		return new TimerJobEntityImpl();
	}

	public List<TimerJobEntity> findTimerJobsToExecute(Page page) {
		throw new UnsupportedOperationException();
	}

	public List<TimerJobEntity> findJobsByTypeAndProcessDefinitionId(String jobHandlerType,String processDefinitionId) {
		throw new UnsupportedOperationException();
	}

	public List<TimerJobEntity> findJobsByTypeAndProcessDefinitionKeyNoTenantId(String jobHandlerType, String processDefinitionKey) {
		return new ArrayList<TimerJobEntity>();
	}

	public List<TimerJobEntity> findJobsByTypeAndProcessDefinitionKeyAndTenantId(String jobHandlerType,
			String processDefinitionKey, String tenantId) {
		throw new UnsupportedOperationException();		
	}

	public List<TimerJobEntity> findJobsByExecutionId(String executionId) {
		List<TimerJobEntity> results = new ArrayList<TimerJobEntity>();
		for (TimerJobEntity timerJobEntity : entities.values()) {
			if (executionId.equals(timerJobEntity.getExecutionId())) {
				results.add(timerJobEntity);
			}
		}
		return results;
	}

	public List<TimerJobEntity> findJobsByProcessInstanceId(String processInstanceId) {
		throw new UnsupportedOperationException();
	}

	public List<Job> findJobsByQueryCriteria(TimerJobQueryImpl jobQuery, Page page) {
		throw new UnsupportedOperationException();
	}

	
	public long findJobCountByQueryCriteria(TimerJobQueryImpl jobQuery) {
		throw new UnsupportedOperationException();
	}

	public void updateJobTenantIdForDeployment(String deploymentId, String newTenantId) {
		throw new UnsupportedOperationException();		
	}


}
