package com.browntape.amz.tws.dto;

import com.amazonaws.services.gtsexternalsecurity.model.*;

import java.io.Serializable;

public class AtwsRequestDto implements Serializable{

  private LabelSpecification labelSpecification;
  private ManifestingOptions manifestingOptions;
  private RequestProperties requestProperties;
  private ShipmentInfoForShipping shipmentInfoForShipping;
  private ServiceOptions serviceOptions;
  String LocalTimeZone;
  String OperatingWarehouseId;
  OperationMode operationMode;
  Long operationalWarehouseId;

  public LabelSpecification getLabelSpecification() {
    return labelSpecification;
  }

  public void setLabelSpecification(LabelSpecification labelSpecification) {
    this.labelSpecification = labelSpecification;
  }

  public ManifestingOptions getManifestingOptions() {
    return manifestingOptions;
  }

  public void setManifestingOptions(ManifestingOptions manifestingOptions) {
    this.manifestingOptions = manifestingOptions;
  }

  public RequestProperties getRequestProperties() {
    return requestProperties;
  }

  public void setRequestProperties(RequestProperties requestProperties) {
    this.requestProperties = requestProperties;
  }

  public ShipmentInfoForShipping getShipmentInfoForShipping() {
    return shipmentInfoForShipping;
  }

  public void setShipmentInfoForShipping(ShipmentInfoForShipping shipmentInfoForShipping) {
    this.shipmentInfoForShipping = shipmentInfoForShipping;
  }

  public ServiceOptions getServiceOptions() {
    return serviceOptions;
  }

  public void setServiceOptions(ServiceOptions serviceOptions) {
    this.serviceOptions = serviceOptions;
  }

  public String getLocalTimeZone() {
    return LocalTimeZone;
  }

  public void setLocalTimeZone(String localTimeZone) {
    LocalTimeZone = localTimeZone;
  }

  public String getOperatingWarehouseId() {
    return OperatingWarehouseId;
  }

  public void setOperatingWarehouseId(String operatingWarehouseId) {
    OperatingWarehouseId = operatingWarehouseId;
  }

  public Long getOperationalWarehouseId() {
    return operationalWarehouseId;
  }

  public void setOperationalWarehouseId(Long operationalWarehouseId) {
    this.operationalWarehouseId = operationalWarehouseId;
  }

  public OperationMode getOperationMode() {
    return operationMode;
  }

  public void setOperationMode(OperationMode operationMode) {
    this.operationMode = operationMode;
  }
}
