package com.browntape.amz.tws.pact;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.gtsexternalsecurity.GTSExternalSecurityService;
import com.amazonaws.services.gtsexternalsecurity.GTSExternalSecurityServiceClient;
import com.browntape.amz.tws.configuration.Configuration;

public abstract class GtsService {
  protected  final  GTSExternalSecurityService gts;
  public GtsService() {
    AWSCredentials awsCredentials = new BasicAWSCredentials(Configuration.AWSAccessKey, Configuration.AWSSecretKey);
    ClientConfiguration clientConfiguration = new ClientConfiguration();
    GTSExternalSecurityService gts = new GTSExternalSecurityServiceClient(awsCredentials, clientConfiguration);
    gts.setEndpoint(Configuration.GTSPreprodEndpoint_EU);
    this.gts = gts;
  }
}
