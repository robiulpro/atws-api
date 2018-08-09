package com.browntape.amz.tws.pact;

import com.browntape.amz.tws.dto.AtwsRequestDto;

public interface AtwsService {

  String requestShippingLabel(AtwsRequestDto atwsRequestDto);
}
