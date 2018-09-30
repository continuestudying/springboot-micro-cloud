package com.test.microservice.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.core.sym.Name;

@Entity(name="EXCHANGE_VALUE")
public class ExchangeValue {
	@Id
	private String id;	
	@Column(name="CURRENCY_FROM")
	private String from;	
	@Column(name="CURRENCY_TO")
	private String to;
	private BigDecimal conversationMultiple;
	private String port;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversationMultiple() {
		return conversationMultiple;
	}
	public void setConversationMultiple(BigDecimal conversationMultiple) {
		this.conversationMultiple = conversationMultiple;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	

}
