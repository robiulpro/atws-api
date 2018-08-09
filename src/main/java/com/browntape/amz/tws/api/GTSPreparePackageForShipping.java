package com.browntape.amz.tws.api;

import com.amazonaws.services.gtsexternalsecurity.model.PreparePackageForShippingRequest;
import com.amazonaws.services.gtsexternalsecurity.model.PreparePackageForShippingResult;
import com.amazonaws.services.gtsexternalsecurity.model.RecoverableException;
import com.amazonaws.services.gtsexternalsecurity.model.UnrecoverableException;
import com.browntape.amz.tws.configuration.Configuration;
import com.browntape.amz.tws.data.PreparePackageForShippingSampleData;
import com.browntape.amz.tws.data.SampleShipmentIdentifiers;
import com.browntape.amz.tws.dto.AtwsRequestDto;
import com.browntape.amz.tws.pact.GtsService;
import com.browntape.amz.tws.response.GTSPreparePackageForShippingResponse;
import com.google.gson.Gson;

import javax.xml.bind.DatatypeConverter;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class GTSPreparePackageForShipping extends GtsService {


  private PreparePackageForShippingRequest request;

  public void buildLabelRequest(AtwsRequestDto atwsRequestDto)
  {
    request= PreparePackageForShippingSampleData.buildPPFSRequest(atwsRequestDto);
    System.out.println("RequestObjectFor Prepare package For Shipping Label:" + request.toString());
  }
	/*
	public GTSPreparePackageForShipping(PreparePackageForShippingRequest request)
	{
		super();
		this.request= request;
	}*/


  public String callPreparePackageForShipping() {
  int maxRetryVal= Configuration.MAX_RETRIES;
    GTSPreparePackageForShippingResponse gtsPreparePackageForShippingResponse = new GTSPreparePackageForShippingResponse();
  for(int i=1;i<=maxRetryVal;){
    try
    {
      PreparePackageForShippingResult result = gts.preparePackageForShipping(this.request);
      System.out.println("PPFSEResponse>>>"+result.toString());
      printLabelData(result);
      SampleShipmentIdentifiers.setAmazonBarcode(result.getAmazonBarcode());
      gtsPreparePackageForShippingResponse.setPreparePackageForShippingResult(result);
    } catch (RecoverableException ex){
      ex.printStackTrace();
      System.out.println("Recoverable Error"+ex.toString());
      i++;
      if(i==maxRetryVal){
        gtsPreparePackageForShippingResponse.setExceptionMessage(ex.toString());
      }
    }
    catch (UnrecoverableException | InvalidMarkException ex) {
      ex.printStackTrace();
      System.out.println("Error"+ex.toString());
      gtsPreparePackageForShippingResponse.setExceptionMessage(ex.toString());
    }
  }
    return new Gson().toJson(gtsPreparePackageForShippingResponse);
  }

  protected void printLabelData(PreparePackageForShippingResult result) {
    System.out.println("Got ship method: " + result.getShippingInfo().getShipMethod());
    System.out.println("ShippingInfo: "+ result.getShippingInfo());
    System.out.println("Tracking Id: " + result.getTrackingId());
    System.out.println("Amazon Barcode: " + result.getAmazonBarcode());
    System.out.println("Label Stream: "+ result.getLabels().get(0).getLabelStream().toString());
    ByteBuffer labelStream = result.getLabels().get(0).getLabelStream();
    System.out.println("LabelStream size"+ labelStream.array().length);
    String labelString = DatatypeConverter.printBase64Binary(labelStream.array());
    System.out.println("Label = \n" +labelString);

  }



}
