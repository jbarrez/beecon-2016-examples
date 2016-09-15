package org.activiti.manager;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.DeadLetterJobQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.DeadLetterJobEntity;
import org.activiti.engine.impl.persistence.entity.DeadLetterJobEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.DeadLetterJobDataManager;
import org.activiti.engine.runtime.Job;

public class InMemoryDeadLetterJobDataManager extends AbstractInMemoryDataManager<DeadLetterJobEntity> implements DeadLetterJobDataManager {

	public InMemoryDeadLetterJobDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	public DeadLetterJobEntity create() {
		return new DeadLetterJobEntityImpl();
	}

	public List<DeadLetterJobEntity> findJobsByExecutionId(String executionId) {
		List<DeadLetterJobEntity> results = new ArrayList<DeadLetterJobEntity>();
		for (DeadLetterJobEntity deadLetter : entities.values()) {
			if (executionId.equals(deadLetter.getExecutionId())) {
				results.add(deadLetter);
			}
		}
		return results;
	}

	public List<Job> findJobsByQueryCriteria(DeadLetterJobQueryImpl jobQuery, Page page) {
		throw new UnsupportedOperationException();
	}

	public long findJobCountByQueryCriteria(DeadLetterJobQueryImpl jobQuery) {
		throw new UnsupportedOperationException();
	}

	public void updateJobTenantIdForDeployment(String deploymentId, String newTenantId) {
		throw new UnsupportedOperationException();
	}

}
