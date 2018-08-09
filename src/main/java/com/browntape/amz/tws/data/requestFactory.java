package com.browntape.amz.tws.data;


import com.amazonaws.services.gtsexternalsecurity.model.PreparePackageForShippingRequest;

import java.util.Calendar;
import java.util.TimeZone;

public class requestFactory {
	public static final String WAREHOUSE_ID="XDEI";
	public static final String localTimeZone=(Calendar.getInstance().getTimeZone()).getDisplayName(false, TimeZone.SHORT);
	
	public PreparePackageForShippingRequest setLabelRequest()
	{
		PreparePackageForShippingRequest labelRequest=new PreparePackageForShippingRequest();
		
		return labelRequest;
	}
	

}
