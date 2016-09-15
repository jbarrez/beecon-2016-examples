package org.activiti.manager;

import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionInfoEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionInfoEntityImpl;
import org.activiti.engine.impl.persistence.entity.data.ProcessDefinitionInfoDataManager;

public class InMemoryProcessDefinitionInfoDataManager extends AbstractInMemoryDataManager<ProcessDefinitionInfoEntity> implements ProcessDefinitionInfoDataManager {

	public InMemoryProcessDefinitionInfoDataManager(ProcessEngineConfigurationImpl processEngineConfiguration) {
		super(processEngineConfiguration);
	}

	public ProcessDefinitionInfoEntity create() {
		return new ProcessDefinitionInfoEntityImpl();
	}

	public ProcessDefinitionInfoEntity findProcessDefinitionInfoByProcessDefinitionId(String processDefinitionId) {
		return null;
	}

}
