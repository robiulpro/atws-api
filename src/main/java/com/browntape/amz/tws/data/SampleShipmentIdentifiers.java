package com.browntape.amz.tws.data;

import java.util.HashMap;
import java.util.Map;

public class SampleShipmentIdentifiers {
	//private static final String SHIPMENT_ID = "DdBGLlpTN";
	private static final String SHIPMENT_ID = "DmBLZhp3N";
	private static final String PACKAGE_ID = "872";
	public static String AmazonBarcode;
	
	public static Map<String,String> getClientRefShipmentId() {
		Map<String,String> clientRefShipmentId = new HashMap<String, String>();
		clientRefShipmentId.put("SHIPMENT_ID", SHIPMENT_ID);
		return clientRefShipmentId;
	}
	public static void setAmazonBarcode(String amazonBarcode)
	{
		AmazonBarcode=amazonBarcode;
	}
	public static String getAmazonBarcode()
	{
		return AmazonBarcode;
	}
	public static Map<String,String> getClientRefPackageIdId() {
		Map<String,String> clientRefPackageId = new HashMap<String, String>();
		clientRefPackageId.put("PACKAGE_ID", PACKAGE_ID);
		return clientRefPackageId;
	}
	
	public static Map<String,Map<String,String>> getClientRefShipmentPackageIdId() {
		Map<String,Map<String,String>> clientRefShipmentPackageId = new HashMap<String, Map<String,String>>();
		clientRefShipmentPackageId.put("clientRefShipmentId", getClientRefShipmentId());
		clientRefShipmentPackageId.put("clientRefPackageId", getClientRefPackageIdId());
		return clientRefShipmentPackageId;
	}
}
