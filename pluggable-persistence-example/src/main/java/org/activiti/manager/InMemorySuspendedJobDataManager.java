package org.activiti.manager;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.SuspendedJobQueryImpl;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.PropertyEntity;
import org.activiti.engine.impl.persistence.entity.PropertyEntityImpl;
import org.activiti.engine.impl.persistence.entity.SuspendedJobEntity;
import org.activiti.engine.impl.persistence.entity.SuspendedJobEntityImpl;
import org.activiti.engine.impl.persistence.entity.TimerJobEntity;
import org.activiti.engine.impl.persistence.entity.data.PropertyDataManager;
import org.activiti.engine.impl.persistence.entity.data.SuspendedJobDataManager;
import org.activiti.engine.runtime.Job;

public class InMemorySuspendedJobDataManager extends AbstractInMemoryDataManager<SuspendedJobEntity> implements SuspendedJobDataManager {

	public InMemorySuspendedJobDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	public SuspendedJobEntity create() {
		return new SuspendedJobEntityImpl();
	}

	public List<SuspendedJobEntity> findJobsByExecutionId(String executionId) {
		List<SuspendedJobEntity> results = new ArrayList<SuspendedJobEntity>();
		for (SuspendedJobEntity suspendedJob : entities.values()) {
			if (executionId.equals(suspendedJob.getExecutionId())) {
				results.add(suspendedJob);
			}
		}
		return results;
	}

	public List<SuspendedJobEntity> findJobsByProcessInstanceId(String processInstanceId) {
		throw new UnsupportedOperationException();
	}

	public List<Job> findJobsByQueryCriteria(SuspendedJobQueryImpl jobQuery, Page page) {
		throw new UnsupportedOperationException();
	}

	public long findJobCountByQueryCriteria(SuspendedJobQueryImpl jobQuery) {
		throw new UnsupportedOperationException();
	}

	public void updateJobTenantIdForDeployment(String deploymentId, String newTenantId) {
		throw new UnsupportedOperationException();
		
	}

}
