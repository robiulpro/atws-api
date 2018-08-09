package com.browntape.amz.tws.data;

import com.amazonaws.services.gtsexternalsecurity.model.ContainerDocumentType;
import com.amazonaws.services.gtsexternalsecurity.model.DocumentFormat;
import com.amazonaws.services.gtsexternalsecurity.model.GetDocumentForContainerRequest;

public class GetDocumentForContainerSampleData {
	public static GetDocumentForContainerRequest buildRequest() {
		GetDocumentForContainerRequest request = new GetDocumentForContainerRequest();
		request.setClientRefShipmentId(SampleShipmentIdentifiers.getClientRefShipmentId());
		request.setClientRefPackageId(SampleShipmentIdentifiers.getClientRefPackageIdId());
		request.setDocumentFormat(DocumentFormat.PDF);
		request.setAmazonBarcode(SampleShipmentIdentifiers.getAmazonBarcode());
		request.setDocumentType(ContainerDocumentType.PRINTABLE_COMMERCIAL_INVOICE);
		request.setNodeName("XDEI");
		return request;
	}
}
