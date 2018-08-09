package com.browntape.amz.tws.data;

import com.amazonaws.services.gtsexternalsecurity.model.ClientRefShipmentPackageId;
import com.amazonaws.services.gtsexternalsecurity.model.ManifestPackagesRequest;
import com.amazonaws.services.gtsexternalsecurity.model.PrintableDocumentsSpecification;

import java.util.*;

public class ManifestPackagesSampleData {
	
	public static ManifestPackagesRequest buildManifestPackagesByIDRequest() {
		ManifestPackagesSampleData sampleData = new ManifestPackagesSampleData();
		
		ManifestPackagesRequest manifestPackagesRequest=new ManifestPackagesRequest();
        List<String> carrierList;
        carrierList = Arrays.asList("UPS");
        manifestPackagesRequest.setCarrierList(carrierList);

        manifestPackagesRequest.setOperatingWarehouseId("MSN1");

        PrintableDocumentsSpecification printableDocumentsSpecification = sampleData.createTestPrintableDocumentsSpecification();
        manifestPackagesRequest.setPrintableDocumentsSpecification(printableDocumentsSpecification);
        List<ClientRefShipmentPackageId> clientRefShipmentPackageIdList = buildClientRefShipmentPackageIdList();
        
        manifestPackagesRequest.setClientRefShipmentPackageIdList(clientRefShipmentPackageIdList);
        return manifestPackagesRequest;
	}
	
	private static List<ClientRefShipmentPackageId> buildClientRefShipmentPackageIdList() {
		List<ClientRefShipmentPackageId> clientRefShipmentPackageIdList = new ArrayList<ClientRefShipmentPackageId>();
		
		//Need to change according to packages that are manifested
		Map<String, String> clientRefPackageId = new HashMap<String, String>();
		clientRefPackageId.put("PACKAGE_ID", "1");
		Map<String, String> clientRefShipmentId = new HashMap<String, String>();
		clientRefShipmentId.put("SHIPMENT_ID", "123456789");
		
		
		ClientRefShipmentPackageId clientRefShipmentPackageId = new ClientRefShipmentPackageId();
		clientRefShipmentPackageId.setClientRefPackageId(clientRefPackageId);
		clientRefShipmentPackageId.setClientRefShipmentId(clientRefShipmentId);
		clientRefShipmentPackageIdList.add(clientRefShipmentPackageId);
		return clientRefShipmentPackageIdList;
	}
	
	private PrintableDocumentsSpecification createTestPrintableDocumentsSpecification() {
        PrintableDocumentsSpecification specification=new PrintableDocumentsSpecification();
        specification.setFormatType("PNG");
        return specification;
    }

}
