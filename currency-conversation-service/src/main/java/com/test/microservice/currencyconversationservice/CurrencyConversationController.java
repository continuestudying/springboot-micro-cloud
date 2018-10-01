package com.test.microservice.currencyconversationservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversationController {
	
	@Autowired
	private Environment env;	
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversationBean getCurrencyConversation(
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal quantity) {
		CurrencyConversationBean bean = new CurrencyConversationBean();
		bean.setId("1001");
		bean.setFrom(from);
		bean.setTo(to);		
		bean.setQuantity(quantity);
		bean.setConversationMultiple(new BigDecimal(65));
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversationMultiple()));
		bean.setPort(env.getProperty("local.server.port"));
		return bean;
		
	}
	
}
