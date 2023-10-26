package com.applicationsuites.documentmanager.dto;

import lombok.Data;

@Data
public class Document {

    private String documentName;

    private String documentTitle;

    private String documentSubtitle;

    private String documentCreationDate;

    private String documentDeletionDate;

    private boolean documentStatus;

    private String documentIdentifier;

    private String documentType;
}
