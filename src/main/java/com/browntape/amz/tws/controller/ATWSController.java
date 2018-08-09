package com.browntape.amz.tws.controller;

import com.browntape.amz.tws.dto.AtwsRequestDto;
import com.browntape.amz.tws.pact.AtwsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.Date;

@Controller
@RequestMapping(path = "/api/atws")
public class ATWSController {

  @Autowired
  AtwsService atwsService;

  @RequestMapping(value = "/requestForShippingLabel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
  public @ResponseBody String requestForShippingLabel(@RequestBody AtwsRequestDto atwsRequestDto){
    System.out.println("atwsRequestDto Object"+ atwsRequestDto.getLocalTimeZone());
    System.out.println("label specifiction"+ atwsRequestDto.getLabelSpecification());
    System.out.println("label Shipment Info For Shipping"+ atwsRequestDto.getShipmentInfoForShipping());

    return getAtwsService().requestShippingLabel(atwsRequestDto);
  }

  public AtwsService getAtwsService() {
    return atwsService;
  }

  public void setAtwsService(AtwsService atwsService) {
    this.atwsService = atwsService;
  }
}
