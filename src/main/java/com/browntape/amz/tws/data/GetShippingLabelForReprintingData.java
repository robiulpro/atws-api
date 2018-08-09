package com.browntape.amz.tws.data;

import com.amazonaws.services.gtsexternalsecurity.model.Dimension;
import com.amazonaws.services.gtsexternalsecurity.model.GetShippingLabelsForReprintingRequest;
import com.amazonaws.services.gtsexternalsecurity.model.LabelDimensions;
import com.amazonaws.services.gtsexternalsecurity.model.LabelSpecification;

public class GetShippingLabelForReprintingData {

	public static GetShippingLabelsForReprintingRequest buildReprintRequest() {
		GetShippingLabelsForReprintingRequest reprintingRequest = new GetShippingLabelsForReprintingRequest();
		reprintingRequest.setClientRefPackageId(SampleShipmentIdentifiers.getClientRefPackageIdId());
		reprintingRequest.setClientRefShipmentId(SampleShipmentIdentifiers.getClientRefShipmentId());
		//reprintingRequest.setAmazonBarcode("22-DjCK5XpJN-123");
		reprintingRequest.setOperatingWarehouseId("XDEI");
		reprintingRequest.setAmazonBarcode(SampleShipmentIdentifiers.getAmazonBarcode());
		reprintingRequest.setLabelSpecification(createLabelSpecification());
		
		return reprintingRequest;
	}
	
	private static LabelSpecification createLabelSpecification() {
        LabelSpecification labelSpecification = new LabelSpecification();
        labelSpecification.setFormatType("ZPL");
        LabelDimensions labelDimensions = new LabelDimensions();
        Dimension length = new Dimension();
        length.setDimensionUnit("IN");
        length.setDimensionValue(6.0);
        Dimension width = new Dimension();
        width.setDimensionUnit("IN");
        width.setDimensionValue(4.0);
        labelDimensions.setLength(length);
        labelDimensions.setWidth(width);
        labelSpecification.setLabelDimensions(labelDimensions);
        return labelSpecification;
    }
	
	

}
