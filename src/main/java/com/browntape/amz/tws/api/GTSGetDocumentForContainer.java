package com.browntape.amz.tws.api;

import java.nio.InvalidMarkException;

import com.amazonaws.services.gtsexternalsecurity.model.*;
import com.browntape.amz.tws.configuration.Configuration;
import com.browntape.amz.tws.data.GetDocumentForContainerSampleData;
import com.browntape.amz.tws.dto.DocumentForContainerRequestDto;
import com.browntape.amz.tws.pact.GtsService;
import com.browntape.amz.tws.response.GTSDocumentForContainerResponse;
import com.google.gson.Gson;

public class GTSGetDocumentForContainer extends GtsService {

	private GetDocumentForContainerRequest request;
	public void buildGetDocumentForContainerReq(DocumentForContainerRequestDto documentForContainerRequestDto)
	{
		request= GetDocumentForContainerSampleData.buildRequest(documentForContainerRequestDto);
		System.out.println("GetDocumentForContainer Request>>>" + request.toString());
	}
	
	public String callgetDocumentForContainer() {

		int maxRetryVal= Configuration.MAX_RETRIES;
		GTSDocumentForContainerResponse gtsDocumentForContainerResponse = new GTSDocumentForContainerResponse();

		for(int i=1;i<=maxRetryVal;) {
			try {
				GetDocumentForContainerResult result = gts.getDocumentForContainer(this.request);
				gtsDocumentForContainerResponse.setGetDocumentForContainerResult(result);
			} catch (RecoverableException ex) {
				ex.printStackTrace();
				System.out.println("Recoverable Error"+ex.toString());
				i++;
				if(i==maxRetryVal){
					gtsDocumentForContainerResponse.setExceptionMessage(ex.toString());
				}
			} catch (UnrecoverableException | InvalidMarkException ex) {
				ex.printStackTrace();
				System.out.println("Error"+ex.toString());
				gtsDocumentForContainerResponse.setExceptionMessage(ex.toString());
			}
		}

		return new Gson().toJson(gtsDocumentForContainerResponse);
	}

}
