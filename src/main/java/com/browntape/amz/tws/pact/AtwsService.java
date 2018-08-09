package com.browntape.amz.tws.pact;

import com.amazonaws.services.gtsexternalsecurity.model.GetDocumentForContainerRequest;
import com.browntape.amz.tws.dto.AtwsRequestDto;
import com.browntape.amz.tws.dto.DocumentForContainerRequestDto;

public interface AtwsService {

  String requestShippingLabel(AtwsRequestDto atwsRequestDto);

  String getDocumentForContainer(DocumentForContainerRequestDto documentForContainerRequestDto);
}
