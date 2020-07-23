package com.dto;

public class SendTxnResponseDTO {
	
	private String message;
	private String responseCode;
	private String agentSessionID;
	private String pinNo;
	private String agentTxnID;
	private Double collectAmt;
	private String collectCcy;
	private Double exRate;
	private Double serviceCharges;
	private Double payoutAmount;
	private String payoutCcy;
	private String txnDate;
	private Double settlementRate;
	private Double settlementDollarRate;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getAgentSessionID() {
		return agentSessionID;
	}
	public void setAgentSessionID(String agentSessionID) {
		this.agentSessionID = agentSessionID;
	}
	public String getPinNo() {
		return pinNo;
	}
	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}
	public String getAgentTxnID() {
		return agentTxnID;
	}
	public void setAgentTxnID(String agentTxnID) {
		this.agentTxnID = agentTxnID;
	}
	public Double getCollectAmt() {
		return collectAmt;
	}
	public void setCollectAmt(Double collectAmt) {
		this.collectAmt = collectAmt;
	}
	public String getCollectCcy() {
		return collectCcy;
	}
	public void setCollectCcy(String collectCcy) {
		this.collectCcy = collectCcy;
	}
	public Double getExRate() {
		return exRate;
	}
	public void setExRate(Double exRate) {
		this.exRate = exRate;
	}
	public Double getServiceCharges() {
		return serviceCharges;
	}
	public void setServiceCharges(Double serviceCharges) {
		this.serviceCharges = serviceCharges;
	}
	public Double getPayoutAmount() {
		return payoutAmount;
	}
	public void setPayoutAmount(Double payoutAmount) {
		this.payoutAmount = payoutAmount;
	}
	public String getPayoutCcy() {
		return payoutCcy;
	}
	public void setPayoutCcy(String payoutCcy) {
		this.payoutCcy = payoutCcy;
	}
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public Double getSettlementRate() {
		return settlementRate;
	}
	public void setSettlementRate(Double settlementRate) {
		this.settlementRate = settlementRate;
	}
	public Double getSettlementDollarRate() {
		return settlementDollarRate;
	}
	public void setSettlementDollarRate(Double settlementDollarRate) {
		this.settlementDollarRate = settlementDollarRate;
	}
	
	
	

}
