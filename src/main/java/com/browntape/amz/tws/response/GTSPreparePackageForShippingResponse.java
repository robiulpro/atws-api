package com.browntape.amz.tws.response;

import com.amazonaws.services.gtsexternalsecurity.model.PreparePackageForShippingResult;

public class GTSPreparePackageForShippingResponse {
  private PreparePackageForShippingResult preparePackageForShippingResult;
  private String exceptionMessage;

  public PreparePackageForShippingResult getPreparePackageForShippingResult() {
    return preparePackageForShippingResult;
  }

  public void setPreparePackageForShippingResult(PreparePackageForShippingResult preparePackageForShippingResult) {
    this.preparePackageForShippingResult = preparePackageForShippingResult;
  }

  public String getExceptionMessage() {
    return exceptionMessage;
  }

  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }
}
