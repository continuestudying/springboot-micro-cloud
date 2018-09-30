package com.test.microservice.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.microservice.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepository repository;


	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
//		ExchangeValue exchangeValue = new ExchangeValue();
//		exchangeValue.setId("1001");
//		exchangeValue.setFrom(from);
//		exchangeValue.setTo(to);
//		exchangeValue.setConversationMultiple(new BigDecimal(6500));
//		exchangeValue.setPort(env.getProperty("local.server.port"));
		
		return repository.findByFromAndTo(from, to);
	}
}
