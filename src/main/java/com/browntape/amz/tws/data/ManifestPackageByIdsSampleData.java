package com.browntape.amz.tws.data;


import com.amazonaws.services.gtsexternalsecurity.model.ClientRefShipmentPackageId;
import com.amazonaws.services.gtsexternalsecurity.model.ManifestPackagesByIdsRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManifestPackageByIdsSampleData {
	
	public static ManifestPackagesByIdsRequest buildManifestPackagesByIDRequest() {
		ManifestPackageByIdsSampleData sampleData = new ManifestPackageByIdsSampleData();
		
		ManifestPackagesByIdsRequest manifestPackagesByIdsRequest = new ManifestPackagesByIdsRequest();
		manifestPackagesByIdsRequest.setClientRefShipmentPackageIdList(buildClientRefShipmentPackageIdList());
		manifestPackagesByIdsRequest.setLoadId("LOAD");
		manifestPackagesByIdsRequest.setOperatingWarehouseId("XDEI");
		//manifestPackagesByIdsRequest.setTrailerId("ExternalTrailer-"+System.currentTimeMillis());
		manifestPackagesByIdsRequest.setTrailerId("ExternalTrailer-12345679");
		
		manifestPackagesByIdsRequest.setAmazonBarcodes(buildAmazonBarcodeList());
		
        return manifestPackagesByIdsRequest;
	}
	public static List<String> buildAmazonBarcodeList()
	{
		List<String> amazonBarcodeList=new ArrayList<String>();
		amazonBarcodeList.add(SampleShipmentIdentifiers.getAmazonBarcode());
		return amazonBarcodeList;
	}
	private static List<ClientRefShipmentPackageId> buildClientRefShipmentPackageIdList() {
		List<ClientRefShipmentPackageId> clientRefShipmentPackageIdList = new ArrayList<ClientRefShipmentPackageId>();
		
		//Need to change according to packages that are manifested
		Map<String, String> clientRefPackageId = SampleShipmentIdentifiers.getClientRefPackageIdId();
		Map<String, String> clientRefShipmentId = SampleShipmentIdentifiers.getClientRefShipmentId();
		
		
		ClientRefShipmentPackageId clientRefShipmentPackageId = new ClientRefShipmentPackageId();
		clientRefShipmentPackageId.setClientRefPackageId(clientRefPackageId);
		clientRefShipmentPackageId.setClientRefShipmentId(clientRefShipmentId);
		clientRefShipmentPackageIdList.add(clientRefShipmentPackageId);
		return clientRefShipmentPackageIdList;
	}
}
