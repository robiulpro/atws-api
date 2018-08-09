package com.browntape.amz.tws.data;

import com.amazonaws.services.gtsexternalsecurity.model.GetDocumentForContainerRequest;
import com.browntape.amz.tws.dto.DocumentForContainerRequestDto;

public class GetDocumentForContainerSampleData {
	public static GetDocumentForContainerRequest buildRequest(DocumentForContainerRequestDto documentForContainerRequestDto) {
		GetDocumentForContainerRequest request = new GetDocumentForContainerRequest();
		request.setClientRefShipmentId(documentForContainerRequestDto.getClientRefShipmentId());
		request.setClientRefPackageId(documentForContainerRequestDto.getClientRefPackageId());
		request.setDocumentFormat(documentForContainerRequestDto.getDocumentFormat());
		request.setAmazonBarcode(documentForContainerRequestDto.getAmazonBarcode());
		request.setDocumentType(documentForContainerRequestDto.getDocumentType());
		request.setNodeName(documentForContainerRequestDto.getNodeName());
		return request;
	}
}
