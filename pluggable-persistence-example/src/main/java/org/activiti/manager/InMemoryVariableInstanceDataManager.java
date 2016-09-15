package org.activiti.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntity;
import org.activiti.engine.impl.persistence.entity.VariableInstanceEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.VariableInstanceDataManager;

/**
 * @author Joram Barrez
 */
public class InMemoryVariableInstanceDataManager extends AbstractInMemoryDataManager<VariableInstanceEntity>
		implements VariableInstanceDataManager {

	public InMemoryVariableInstanceDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	public VariableInstanceEntity create() {
		return new VariableInstanceEntityImpl();
	}

	public List<VariableInstanceEntity> findVariableInstancesByTaskId(String taskId) {
		List<VariableInstanceEntity> results = new ArrayList<VariableInstanceEntity>();
		for (VariableInstanceEntity variableInstanceEntity : entities.values()) {
			if (variableInstanceEntity.getTaskId() != null
					&& variableInstanceEntity.getTaskId().equals(variableInstanceEntity)) {
				results.add(variableInstanceEntity);
			}
		}
		return results;
	}

	public VariableInstanceEntity findVariableInstanceByExecutionAndName(String executionId, String variableName) {
		throw new UnsupportedOperationException();
	}

	public List<VariableInstanceEntity> findVariableInstancesByExecutionAndNames(String executionId,
			Collection<String> names) {
		throw new UnsupportedOperationException();
	}

	public VariableInstanceEntity findVariableInstanceByTaskAndName(String taskId, String variableName) {
		throw new UnsupportedOperationException();
	}

	public List<VariableInstanceEntity> findVariableInstancesByTaskAndNames(String taskId, Collection<String> names) {
		throw new UnsupportedOperationException();
	}

	public List<VariableInstanceEntity> findVariableInstancesByTaskIds(Set<String> taskIds) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<VariableInstanceEntity> findVariableInstancesByExecutionId(String executionId) {
		List<VariableInstanceEntity> results = new ArrayList<VariableInstanceEntity>();
		for (VariableInstanceEntity variableInstanceEntity : entities.values()) {
			if (variableInstanceEntity.getExecutionId() != null
					&& variableInstanceEntity.getExecutionId().equals(executionId)) {
				results.add(variableInstanceEntity);
			}
		}
		return results;
	}

	public List<VariableInstanceEntity> findVariableInstancesByExecutionIds(Set<String> executionIds) {
		throw new UnsupportedOperationException();
	}

}
