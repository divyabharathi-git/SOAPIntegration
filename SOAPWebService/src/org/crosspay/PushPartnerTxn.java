package org.crosspay;

import com.dto.SendTxnRequestDTO;
import com.dto.SendTxnResponseDTO;
import com.service.SendTxnService;

public class PushPartnerTxn {

	public static void main(String[] args) {
		
		SendTxnRequestDTO req =  new SendTxnRequestDTO();
		SendTxnResponseDTO res = new SendTxnResponseDTO();
		
		//Sample values
		req.setAgentCode("UAE001");
		req.setUserID("001user");
		req.setAgentSessionID("sadsad");
		req.setAgentTxnID("110089");
		req.setLocationID("Dubai");
		req.setSenderFirstName("divya");
		req.setSenderLastName("venkatesan");
		req.setSenderMiddleName("gfsfas");
		req.setSenderLastName("adsdsd");
		req.setSenderGender("female");
		
		SendTxnService s = new SendTxnService();
		res = s.SendTransaction(req);
		
		if(res.getResponseCode() == "0") {
			//todo - Success handler
		}else {
			//todo - failure handler
		}

	}

}
