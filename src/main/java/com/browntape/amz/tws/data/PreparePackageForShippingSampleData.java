package com.browntape.amz.tws.data;


import com.amazonaws.services.gtsexternalsecurity.model.*;
import com.browntape.amz.tws.dto.AtwsRequestDto;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class PreparePackageForShippingSampleData {

	public static PreparePackageForShippingRequest buildPPFSRequest(AtwsRequestDto atwsRequestDto) {
		PreparePackageForShippingSampleData sampleData = new PreparePackageForShippingSampleData();
    	
    	PreparePackageForShippingRequest request = new PreparePackageForShippingRequest();
  	  	request.setLocalTimeZone(atwsRequestDto.getLocalTimeZone());
  	  	request.setOperationMode(atwsRequestDto.getOperationMode());
        
        ServiceOptions serviceOptions = sampleData.createServiceOptions(atwsRequestDto);
        request.setServiceOptions(serviceOptions);
        request.setOperatingWarehouseId(atwsRequestDto.getOperatingWarehouseId());
        ShipmentInfoForShipping shipmentInfo = atwsRequestDto.getShipmentInfoForShipping();//sampleData.createShipmentInfoForShipping(atwsRequestDto);
    ItemInfoForShipping itemInfo = new ItemInfoForShipping();
    itemInfo.setASIN("X000TKJP2N");
    itemInfo.setQuantity(1);
    List<ItemInfoForShipping> itemsInfo = Collections.singletonList(itemInfo);
    shipmentInfo.getPackageInfo().setItemsInfo(itemsInfo);
    System.out.println(new Gson().toJson(itemInfo));
        request.setShipmentInfo(shipmentInfo);
        LabelSpecification labelSpecification = atwsRequestDto.getLabelSpecification();//sampleData.createLabelSpecification();
        request.setLabelSpecification(labelSpecification);
        /**ManifestingOptions manifestingOptions = new ManifestingOptions();
        manifestingOptions.setWillUseManifestingAPI(atwsRequestDto.getManifestingOptions().getWillUseManifestingAPI());*/
        /*
         * This is require if you implement automated retry based on recoverable exception
         * For Retry call requestId should be same and sequence number will increase by one (starting from 1).
         * If Request Id change then System consider the request for reslam.
         * System will overrides all the previous data with new data
         */
        RequestProperties requestproperty = atwsRequestDto.getRequestProperties();/* new RequestProperties();
        requestproperty.setRequestId("ExternalClientRequest-"+System.currentTimeMillis());
        requestproperty.setSequenceNumber(1);*/
        request.setRequestProperties(requestproperty);
        request.setManifestingOptions(atwsRequestDto.getManifestingOptions());

        return request;
	}


	private ShipmentInfoForShipping createShipmentInfoForShipping(AtwsRequestDto atwsRequestDto) {
		ShipmentInfoForShipping shipmentInfo = new ShipmentInfoForShipping();
        shipmentInfo.setClientRefShipmentId(atwsRequestDto.getShipmentInfoForShipping().getClientRefShipmentId()/*SampleShipmentIdentifiers.getClientRefShipmentId()*/);
        shipmentInfo.setOriginWarehouseId(atwsRequestDto.getShipmentInfoForShipping().getOriginWarehouseId());
        PackageInfoForShipping packageInfo = atwsRequestDto.getShipmentInfoForShipping().getPackageInfo();
        shipmentInfo.setPackageInfo(packageInfo);
        return shipmentInfo;
	}

	private PackageInfoForShipping createPackageInfoForShipping() {
        PackageInfoForShipping packageInfo = new PackageInfoForShipping();
        packageInfo.setClientRefPackageId(SampleShipmentIdentifiers.getClientRefPackageIdId());
        Dimension Height = new Dimension();
        Height.setDimensionUnit("CM");
        Height.setDimensionValue(10.0);
        packageInfo.setHeight(Height);
        Dimension Length = new Dimension();
        Length.setDimensionUnit("CM");
        Length.setDimensionValue(55.0);
        packageInfo.setLength(Length);
        Dimension Width = new Dimension();
        Width.setDimensionUnit("CM");
        Width.setDimensionValue(35.0);
        packageInfo.setWidth(Width);
        Weight weight = new Weight();
        weight.setWeightUnit("LB");
        weight.setWeightValue(6.327266506228941);
        packageInfo.setWeight(weight);

        List<ItemInfoForShipping> itemsInfo = createItemInfoForShipping();
        packageInfo.setItemsInfo(itemsInfo);
        return packageInfo;
    }

    private List<ItemInfoForShipping> createItemInfoForShipping() {
        ItemInfoForShipping itemInfo = new ItemInfoForShipping();
        itemInfo.setASIN("B003Y3XG2E");
        itemInfo.setQuantity(1);
        List<ItemInfoForShipping> itemsInfo = Collections.singletonList(itemInfo);
        System.out.println(new Gson().toJson(itemInfo));
        return itemsInfo;
    }

	private ServiceOptions createServiceOptions(AtwsRequestDto atwsRequestDto) {
		ServiceOptions serviceOptions = new ServiceOptions();
        PickUpInfo pickUpInfo = atwsRequestDto.getServiceOptions().getPickUpInfo();
       /* pickUpInfo.setPickUpType();//(PickUpType.PICK_UP_ARRANGEMENT_NOT_REQUIRED);
        pickUpInfo.setReadyToPickUpTimeUTC(new Date());*/
        //pickUpInfo.setReadyToPickUpTimeUTC(null);
        serviceOptions.setPickUpInfo(pickUpInfo);
        serviceOptions.setRequiresGuaranteedPromisedDelivery(atwsRequestDto.getServiceOptions().getRequiresGuaranteedPromisedDelivery());
        return serviceOptions;
	}
	
    private LabelSpecification createLabelSpecification() {
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
