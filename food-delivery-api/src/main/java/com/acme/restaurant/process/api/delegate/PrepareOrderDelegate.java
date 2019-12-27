package com.acme.restaurant.process.api.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("foodPreparation")
/**
 * This Class is invoked when the the "PrepareFood" activity is called
 * 
 * @author Test
 *
 */
public class PrepareOrderDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		//Extract Request
		String foodOrderName=(String)execution.getVariable("FoodOrderName");
		String drinkOrderName=(String)execution.getVariable("DrinkOrderName");
		
		System.out.println("foodOrderName"+foodOrderName);
		System.out.println("DrinkOrderName"+drinkOrderName);
		//Process Request
		System.out.println("Order is Ready");		
		////Create Response
		execution.setVariable("FoodOrderStatus",foodOrderName+ drinkOrderName+ "is Completed");
	}

}
