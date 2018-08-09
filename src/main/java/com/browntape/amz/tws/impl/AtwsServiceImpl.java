package com.browntape.amz.tws.impl;

import com.browntape.amz.tws.api.GTSPreparePackageForShipping;
import com.browntape.amz.tws.api.GTSGetDocumentForContainer;
import com.browntape.amz.tws.dto.AtwsRequestDto;
import com.browntape.amz.tws.dto.DocumentForContainerRequestDto;
import com.browntape.amz.tws.pact.AtwsService;
import org.springframework.stereotype.Service;

@Service
public class AtwsServiceImpl implements AtwsService{


  @Override
  public String requestShippingLabel(AtwsRequestDto atwsRequestDto) {

    System.out.println("inside service Impl");

    GTSPreparePackageForShipping gtsLabel = new GTSPreparePackageForShipping();
    gtsLabel.buildLabelRequest(atwsRequestDto);

    return gtsLabel.callPreparePackageForShipping();
  }


  @Override
  public String getDocumentForContainer(DocumentForContainerRequestDto documentForContainerRequestDto){
    System.out.println("inside service method");
    GTSGetDocumentForContainer gtsGetDocumentForContainer = new GTSGetDocumentForContainer();
    gtsGetDocumentForContainer.buildGetDocumentForContainerReq(documentForContainerRequestDto);
    return gtsGetDocumentForContainer.callgetDocumentForContainer();
  }


}
