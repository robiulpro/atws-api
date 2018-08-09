package com.browntape.amz.tws.dto;

import java.io.Serializable;
import java.util.Map;

public class DocumentForContainerRequestDto implements Serializable {

    private Map<String, String> clientRefShipmentId;
    private Map<String, String> clientRefPackageId;
    private String amazonBarcode;
    private String documentType;
    private String documentFormat;
    private String nodeName;


    public Map<String, String> getClientRefShipmentId() {
        return clientRefShipmentId;
    }

    public void setClientRefShipmentId(Map<String, String> clientRefShipmentId) {
        this.clientRefShipmentId = clientRefShipmentId;
    }

    public Map<String, String> getClientRefPackageId() {
        return clientRefPackageId;
    }

    public void setClientRefPackageId(Map<String, String> clientRefPackageId) {
        this.clientRefPackageId = clientRefPackageId;
    }

    public String getAmazonBarcode() {
        return amazonBarcode;
    }

    public void setAmazonBarcode(String amazonBarcode) {
        this.amazonBarcode = amazonBarcode;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(String documentFormat) {
        this.documentFormat = documentFormat;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
