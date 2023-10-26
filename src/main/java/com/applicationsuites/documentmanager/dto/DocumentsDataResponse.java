package com.applicationsuites.documentmanager.dto;

import lombok.Data;

import java.util.List;

@Data
public class DocumentsDataResponse {

    private List<Document> documents;

    private boolean moreRecordsAvailable;

    private int totalAmount;
}
