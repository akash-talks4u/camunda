package com.acme.fnol.process.api.fnol_process_api.delegate;

import java.util.UUID;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import com.acme.fnol.process.api.fnol_process_api.LoggerDelegate;


@Service("generateClaimId")
public class GenerateClaimIdDelegate implements JavaDelegate {
	
	private final Logger LOGGER = Logger.getLogger(GenerateClaimIdDelegate.class.getName());


	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        
		execution.setVariable("ClaimId", randomUUIDString);

		LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "processDefinitionId=" + execution.getProcessDefinitionId()
	            + ", activtyId=" + execution.getCurrentActivityId()
	            + ", activtyName='" + execution.getCurrentActivityName() + "'"
	            + ", processInstanceId=" + execution.getProcessInstanceId()
	            + ", businessKey=" + execution.getProcessBusinessKey()
	            + ", executionId=" + execution.getId()
	            + " \n\n");
		
		LOGGER.info("ClaimId:"+randomUUIDString);
		
	}

}
