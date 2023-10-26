package com.applicationsuites.documentmanager.dto;

import lombok.Data;

@Data
public class PdfViewResponse {

    private String pdfEncoded;

    private int errorCode;

    private String errorMessage;
}
