package com.test.microservice.currencyconversationservice;

import java.math.BigDecimal;

public class CurrencyConversationBean {

	private String id;
	private String from;
	private String to;
	private BigDecimal conversationMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	
	
}
