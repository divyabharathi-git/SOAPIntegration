package com.service;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.dto.SendTxnRequestDTO;
import com.dto.SendTxnResponseDTO;
import com.service.SendTxnService;
import com.utils.CommonUtils;

public class SendTxnService{

	public SendTxnResponseDTO SendTransaction(SendTxnRequestDTO reqDTO) {
		
		String wsUrl = ""; //URL should be added
		String responseCode = "";
		String message = "";
		
		SendTxnResponseDTO resDTO = new SendTxnResponseDTO();
		try {
			String xmlInput = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:cws=\"ClientWebService\">"
				      +"<soapenv:Header/>"
				      +"<soapenv:Body>"
				      +"<rem:SendTransaction>"
				      +"<cws:AGENT_CODE>"+reqDTO.getAgentCode()+"A</cws:AGENT_CODE>"
				      +"<cws:USER_ID>"+reqDTO.getUserID()+"</cws:USER_ID>"
				      +"<cws:AGENT_SESSION_ID>"+reqDTO.getAgentSessionID()+"</cws:AGENT_SESSION_ID>"
				      +"<cws:AGENT_TXNID>"+reqDTO.getAgentTxnID()+"</cws:AGENT_TXNID>"
				      +"<cws:LOCATION_ID>"+reqDTO.getLocationID()+"</cws:LOCATION_ID>"
				      +"<cws:SENDER_FIRST_NAME>"+reqDTO.getSenderFirstName()+"</cws:SENDER_FIRST_NAME>"
				      +"<cws:SENDER_MIDDLE_NAME>"+reqDTO.getSenderMiddleName()+"</cws:SENDER_MIDDLE_NAME>"
				      +"<cws:SENDER_LAST_NAME>"+reqDTO.getSenderLastName()+"</cws:SENDER_LAST_NAME>"
				      +"<cws:SENDER_GENDER>"+reqDTO.getSenderGender()+"</cws:SENDER_GENDER>"
				      +"<cws:SENDER_ADDRESS>"+reqDTO.getSenderAddress()+"</cws:SENDER_ADDRESS>"
				      +"<cws:SENDER_CITY>"+reqDTO.getSenderCity()+"</cws:SENDER_CITY>"
				      +"<cws:SENDER_COUNTRY>"+reqDTO.getSenderCountry()+"</cws:SENDER_COUNTRY>"
				      +"<cws:SENDER_ID_TYPE>"+reqDTO.getSenderIDType()+"</cws:SENDER_ID_TYPE>"
				      +"<cws:SENDER_ID_NUMBER>"+reqDTO.getSenderIDNumber()+"</cws:SENDER_ID_NUMBER>"
				      +"<cws:SENDER_ID_ISSUE_DATE>"+reqDTO.getSenderIDIssueDate()+"</cws:SENDER_ID_ISSUE_DATE>"
				      +"<cws:SENDER_ID_EXPIRE_DATE>"+reqDTO.getSenderIDExpiryDate()+"</cws:SENDER_ID_EXPIRE_DATE>"
				      +"<cws:SENDER_DATE_OF_BIRTH>"+reqDTO.getSenderDateOfBirth()+"</cws:SENDER_DATE_OF_BIRTH>"
				      +"<cws:SENDER_MOBILE>"+reqDTO.getSenderMobile()+"</cws:SENDER_MOBILE>"
				      +"<cws:SOURCE_OF_FUND>"+reqDTO.getSourceOfFund()+"</cws:SOURCE_OF_FUND>"
				      +"<cws:SENDER_OCCUPATION>"+reqDTO.getSenderOccupation()+"</cws:SENDER_OCCUPATION>"
				      +"<cws:SENDER_NATIONALITY>"+reqDTO.getSenderNationality()+"</cws:SENDER_NATIONALITY>"
				      +"<cws:RECEIVER_FIRST_NAME>"+reqDTO.getReceiverFirstName()+"</cws:RECEIVER_FIRST_NAME>"
				      +"<cws:RECEIVER_MIDDLE_NAME>"+reqDTO.getReceiverMiddleName()+"</cws:RECEIVER_MIDDLE_NAME>"
				      +"<cws:RECEIVER_LAST_NAME>"+reqDTO.getReceiverLastName()+"</cws:RECEIVER_LAST_NAME>"
				      +"<cws:RECEIVER_ADDRESS>"+reqDTO.getReceiverAddress()+"</cws:RECEIVER_ADDRESS>"
				      +"<cws:RECEIVER_CITY>"+reqDTO.getReceiverCity()+"</cws:RECEIVER_CITY>"
				      +"<cws:RECEIVER_COUNTRY>"+reqDTO.getReceiverCountry()+"</cws:RECEIVER_COUNTRY>"
				      +"<cws:RECEIVER_CONTACT_NUMBER>"+reqDTO.getReceiverContactNumber()+"</cws:RECEIVER_CONTACT_NUMBER>"
				      +"<cws:RELATIONSHIP_TO_BENEFICIARY>"+reqDTO.getRelationshipToBeneficiary()+"</cws:RELATIONSHIP_TO_BENEFICIARY>"
				      +"<cws:PAYMENT_MODE>"+reqDTO.getPaymentMode()+"</cws:PAYMENT_MODE>"
				      +"<cws:BANK_ID>"+reqDTO.getBankID()+"</cws:BANK_ID>"
				      +"<cws:BANK_NAME>"+reqDTO.getBankName()+"</cws:BANK_NAME>"
				      +"<cws:BANK_BRANCH_NAME>"+reqDTO.getBankBranchName()+"</cws:BANK_BRANCH_NAME>"
				      +"<cws:BANK_ACCOUNT_NUMBER>"+reqDTO.getBankAccountNumber()+"</cws:BANK_ACCOUNT_NUMBER>"
				      +"<cws:CALC_BY>"+reqDTO.getCalcBy()+"</cws:CALC_BY>"
				      +"<cws:TRANSFER_AMOUNT>"+reqDTO.getTransferAmount()+"</cws:TRANSFER_AMOUNT>"
				      +"<cws:OURSERVICE_CHARGE>"+reqDTO.getOutServiceCharge()+"</cws:OURSERVICE_CHARGE>"
				      +"<cws:TRANSACTION_EXCHANGERATE>"+reqDTO.getTxnExchangeRate()+"</cws:TRANSACTION_EXCHANGERATE>"
				      +"<cws:SETTLEMENT_DOLLARRATE>"+reqDTO.getSettlementDollarRate()+"</cws:SETTLEMENT_DOLLARRATE>"
				      +"<cws:PURPOSE_OF_REMITTANCE>"+reqDTO.getPurposeOfRemittance()+"</cws:PURPOSE_OF_REMITTANCE>"
				      +"<cws:AUTHORIZED_REQUIRED>"+reqDTO.getAuthRequired()+"</cws:AUTHORIZED_REQUIRED>"
				      +"<cws:SIGNATURE>"+reqDTO.getSignature()+"</cws:SIGNATURE>"
				      +"</cws:SendTransaction>"
				      +"</soapenv:Body>"
				      +"</soapenv:Envelope>" ;
			
			
			
					  String outputString = CommonUtils.createConnection(wsUrl,xmlInput);
					
					  Document document = CommonUtils.parseXmlFile(outputString);
					  responseCode = document.getElementsByTagName("CODE").item(0).getTextContent();
				      resDTO.setResponseCode(responseCode);
				      
				      String agentSessionID = document.getElementsByTagName("AGENT_SESSION_ID").item(0).getTextContent();
				      resDTO.setAgentSessionID(agentSessionID);
				      
				      message = document.getElementsByTagName("MESSAGE").item(0).getTextContent();
				      resDTO.setMessage(message);
				      
				      String pinNo = document.getElementsByTagName("PINNO").item(0).getTextContent();
				      resDTO.setPinNo(pinNo);
				      
				      String agentTxnID = document.getElementsByTagName("AGENT_TXNID").item(0).getTextContent();
				      resDTO.setAgentTxnID(agentTxnID);
				      
				      String collectAmt = document.getElementsByTagName("COLLECT_AMT").item(0).getTextContent();
				      resDTO.setCollectAmt(Double.parseDouble(collectAmt));
				      
				      String collectCcy = document.getElementsByTagName("COLLECT_CURRENCY").item(0).getTextContent();
				      resDTO.setCollectCcy(collectCcy);
				      
				      String exRate = document.getElementsByTagName("EXCHANGE_RATE").item(0).getTextContent();
				      resDTO.setExRate(Double.parseDouble(exRate));
				      
				      String serviceCharges = document.getElementsByTagName("SERVICE_CHARGE").item(0).getTextContent();
				      resDTO.setServiceCharges(Double.parseDouble(serviceCharges));
				      
				      String payoutAmount = document.getElementsByTagName("PAYOUTAMT").item(0).getTextContent();
				      resDTO.setPayoutAmount(Double.parseDouble(payoutAmount));
				      
				      String payoutCcy = document.getElementsByTagName("PAYOUTCURRENCY").item(0).getTextContent();
				      resDTO.setPayoutCcy(payoutCcy);
				      
				      String txnDate = document.getElementsByTagName("TXN_DATE").item(0).getTextContent();
				      resDTO.setTxnDate(txnDate);
				      
				      String settlementRate = document.getElementsByTagName("SETTLEMENT_RATE").item(0).getTextContent();
				      resDTO.setSettlementRate(Double.parseDouble(settlementRate));
				      
				      String settlementDollarRate = document.getElementsByTagName("SETTLEMENT_DOLLARRATE").item(0).getTextContent();
				      resDTO.setSettlementDollarRate(Double.parseDouble(settlementDollarRate));
				      
				      
					
		} 
		catch (MalformedURLException e) {
			resDTO.setResponseCode(responseCode);
			resDTO.setMessage(message);
			e.printStackTrace();
		}
		catch (IOException e) {
			resDTO.setResponseCode(responseCode);
			resDTO.setMessage(message);
			e.printStackTrace();
		}
		catch (ParserConfigurationException e) {
			resDTO.setResponseCode(responseCode);
			resDTO.setMessage(message);
			e.printStackTrace();
		}
		catch (SAXException e) {
			resDTO.setResponseCode(responseCode);
			resDTO.setMessage(message);
			e.printStackTrace();
		}
		return resDTO;
			   
	}


	
}
