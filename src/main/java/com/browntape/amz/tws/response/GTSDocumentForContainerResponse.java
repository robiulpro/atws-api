package com.browntape.amz.tws.response;

import com.amazonaws.services.gtsexternalsecurity.model.GetDocumentForContainerResult;

public class GTSDocumentForContainerResponse {

    private GetDocumentForContainerResult getDocumentForContainerResult;

    private String exceptionMessage;

    public GetDocumentForContainerResult getGetDocumentForContainerResult() {
        return getDocumentForContainerResult;
    }

    public void setGetDocumentForContainerResult(GetDocumentForContainerResult getDocumentForContainerResult) {
        this.getDocumentForContainerResult = getDocumentForContainerResult;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
