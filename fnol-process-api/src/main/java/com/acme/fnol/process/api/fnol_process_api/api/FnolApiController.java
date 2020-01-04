package com.acme.fnol.process.api.fnol_process_api.api;

import com.acme.fnol.process.api.fnol_process_api.model.Claim;
import com.acme.fnol.process.api.fnol_process_api.model.ErrorDetails;
import com.acme.fnol.process.api.fnol_process_api.model.PolicyNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.variable.VariableMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.logging.Logger;

@javax.annotation.Generated(value = "com.acme.fnol.process.api.fnol_process_api.codegen.languages.SpringCodegen", date = "2020-01-03T23:47:43.320Z")

@Controller
@ControllerAdvice
public class FnolApiController implements FnolApi {

	private final Logger LOGGER = Logger.getLogger(FnolApiController.class.getName());
	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@org.springframework.beans.factory.annotation.Autowired
	public FnolApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Claim> addFirstNoticeOfLoss(
			@ApiParam(value = "Create FNOL") @Valid @RequestBody Claim claim) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				// Instantiate a "fnol-process-api" Process
				ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("fnol-process-api");
				// Get the Task Id
				Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list().get(0);
				// Populate the Variables
				Map<String, Object> processReqVariables = prepareRequest(claim);
				VariableMap processInstanceVariables = taskService.completeWithVariablesInReturn(task.getId(),
						processReqVariables, false);
				String claimId = prepareResponse(processInstanceVariables);
				if(claimId !=null) {
					claim.setId(claimId);
					return new ResponseEntity<Claim>(claim, HttpStatus.OK);
				}else {
					//claim.setId(claimId);
					throw new PolicyNotFoundException();
				}
				
			} catch (Exception e) {
				LOGGER.log(java.util.logging.Level.SEVERE,
						"Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Claim>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Claim>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
	  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	      request.getDescription(false));
	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	private Map<String, Object> prepareRequest(Claim claim) {
		Map<String, Object> variables = new HashMap<String, Object>();
		// Create a process variables
		variables.put("Location", claim.getLocation());
		variables.put("PolicyNumber", claim.getPolicyNumber());
		variables.put("Date", claim.getDate());
		variables.put("Car_Make", claim.getCar().getMake());
		variables.put("Car_Model", claim.getCar().getModel());
		variables.put("Car_Year", claim.getCar().getYear());
		return variables;
	}

	private String prepareResponse(VariableMap processInstanceVariables) {
		return (String) processInstanceVariables.get("ClaimId");
	}

	@Override
	public ResponseEntity<List<Claim>> searchInventory(@Valid String claimid) {
		// TODO Auto-generated method stub
		return null;
	}

}
