package com.acme.fnol.process.api.fnol_process_api.delegate;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;


@Service("validatePolicyDetails")
public class ValidatePolicyDetailsDelegate implements JavaDelegate {
	
	private final Logger LOGGER = Logger.getLogger(ValidatePolicyDetailsDelegate.class.getName());


	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		Long policyNumber=(Long)execution.getVariable("PolicyNumber");
		boolean isPolicyValid=true;
		if(policyNumber%2==0) {
			isPolicyValid=false;
		}
		
		execution.setVariable("isPolicyValid", isPolicyValid);
		
		LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "processDefinitionId=" + execution.getProcessDefinitionId()
	            + ", activtyId=" + execution.getCurrentActivityId()
	            + ", activtyName='" + execution.getCurrentActivityName() + "'"
	            + ", processInstanceId=" + execution.getProcessInstanceId()
	            + ", businessKey=" + execution.getProcessBusinessKey()
	            + ", executionId=" + execution.getId()
	            + " \n\n");
		
		LOGGER.info("isPolicyValid:"+isPolicyValid);

	}

}
