package com.test.microservice.currencyconversationservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import feign.Feign;

@RestController
public class CurrencyConversationController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeServiceProxy feignProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversationBean getCurrencyConversation(
			@PathVariable String from, 
			@PathVariable String to, 
			@PathVariable BigDecimal quantity) {
//		CurrencyConversationBean bean = new CurrencyConversationBean();
//		bean.setId("1001");
//		bean.setFrom(from);
//		bean.setTo(to);		
//		bean.setQuantity(quantity);
//		bean.setConversationMultiple(new BigDecimal(65));
//		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversationMultiple()));
//		bean.setPort(env.getProperty("local.server.port"));
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8000/currency-exchange/from/" + from + "/to/" + to ;
		ResponseEntity<CurrencyConversationBean> response = restTemplate.getForEntity(url, CurrencyConversationBean.class);
		CurrencyConversationBean bean = response.getBody();
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversationMultiple()));
		bean.setPort(env.getProperty("local.server.port"));
		
		return bean;
		
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversationBean getCurrencyConversationViaFeignProxy(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversationBean bean = feignProxy.getCurrencyConversation(from, to);
		bean.setQuantity(quantity);
		bean.setTotalCalculatedAmount(quantity.multiply(bean.getConversationMultiple()));
		return bean;
	}
	
}
