package com.browntape.amz.tws.data;


import com.amazonaws.services.gtsexternalsecurity.model.CancelPackageShippingRequest;

public class PrepareCancelPackageShippingSampleData {
	
	public static CancelPackageShippingRequest buildCancelPackageForShippingRequest() {
		
    	
		CancelPackageShippingRequest request = new CancelPackageShippingRequest();
		request.setClientRefShipmentId(SampleShipmentIdentifiers.getClientRefShipmentId());
        request.setClientRefPackageId(SampleShipmentIdentifiers.getClientRefPackageIdId());
        request.setAmazonBarcode(SampleShipmentIdentifiers.getAmazonBarcode());
        request.setOperatingWarehouseId("XDEI");
        return request;
	}

}
