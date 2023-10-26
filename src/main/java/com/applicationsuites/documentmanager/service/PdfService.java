package com.applicationsuites.documentmanager.service;

import com.applicationsuites.documentmanager.dto.Document;
import com.applicationsuites.documentmanager.dto.DocumentsDataResponse;
import com.applicationsuites.documentmanager.dto.PdfViewResponse;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

@Service
public class PdfService {

    public PdfViewResponse getPdfEncoded(String fileName) {
        Resource resource = new ClassPathResource("pdfs/" + fileName);
        PdfViewResponse serviceResponse = new PdfViewResponse();
        try {
            byte[] pdfBytes = IOUtils.toByteArray(resource.getInputStream());
            serviceResponse.setPdfEncoded(Base64.getEncoder().encodeToString(pdfBytes));
            return serviceResponse;
        } catch (IOException e) {
            // Handle the exception, e.g., return a 404 Not Found response
            serviceResponse.setErrorCode(404);
            serviceResponse.setErrorMessage("File not found");
            return serviceResponse;
        }
    }

    public DocumentsDataResponse getMockData() {
        Document document = new Document();
        String uuid = UUID.randomUUID().toString();
        document.setDocumentName("A.pdf");
        document.setDocumentTitle("Letter of Credit | SB Road - Pune | AB01 1234 1234 1234 1234 12");
        document.setDocumentSubtitle("Test document | ".concat(uuid).concat(" XYZABCD"));
        document.setDocumentCreationDate("16.08.2023");
        document.setDocumentDeletionDate("16.08.2024");
        document.setDocumentStatus(false);
        document.setDocumentIdentifier(uuid);
        document.setDocumentType("CUSTOMER");

        Document document1 = new Document();
        String uuid1 = UUID.randomUUID().toString();
        document1.setDocumentName("B.pdf");
        document1.setDocumentTitle("Letter of Credit | Magarpatta City - Pune | AB01 1234 1234 1234 1234 12");
        document1.setDocumentSubtitle("Test document | ".concat(uuid1).concat(" DBCQ34"));
        document1.setDocumentCreationDate("10.01.2023");
        document1.setDocumentDeletionDate("20.02.2024");
        document1.setDocumentStatus(false);
        document1.setDocumentIdentifier(uuid1);
        document1.setDocumentType("CUSTOMER");

        Document document2 = new Document();
        String uuid2 = UUID.randomUUID().toString();
        document2.setDocumentName("C.pdf");
        document2.setDocumentTitle("Letter of Credit | Kharadi - Pune | AB01 1234 4321 1234 1234 12");
        document2.setDocumentSubtitle("Test document | ".concat(uuid2).concat(" BNKIOU"));
        document2.setDocumentCreationDate("23.01.2023");
        document2.setDocumentDeletionDate("17.02.2024");
        document2.setDocumentStatus(false);
        document2.setDocumentIdentifier(uuid2);
        document2.setDocumentType("CUSTOMER");

        Document document3 = new Document();
        String uuid3 = UUID.randomUUID().toString();
        document3.setDocumentName("D.pdf");
        document3.setDocumentTitle("Letter of Credit | Katraj - Pune | AB01 1234 1234 1234 9876 12");
        document3.setDocumentSubtitle("Test document | ".concat(uuid3).concat(" MBTR45"));
        document3.setDocumentCreationDate("10.01.2023");
        document3.setDocumentDeletionDate("20.02.2024");
        document3.setDocumentStatus(false);
        document3.setDocumentIdentifier(uuid3);
        document3.setDocumentType("CUSTOMER");

        Document document4 = new Document();
        String uuid4 = UUID.randomUUID().toString();
        document4.setDocumentName("E.pdf");
        document4.setDocumentTitle("Letter of Credit | Wakad - Pune | AB01 1234 1234 1234 5432 12");
        document4.setDocumentSubtitle("Test document | ".concat(uuid4).concat(" DBCQ34"));
        document4.setDocumentCreationDate("10.01.2023");
        document4.setDocumentDeletionDate("20.02.2024");
        document4.setDocumentStatus(false);
        document4.setDocumentIdentifier(uuid4);
        document4.setDocumentType("CUSTOMER");

        Document document5 = new Document();
        String uuid5 = UUID.randomUUID().toString();
        document5.setDocumentName("F.pdf");
        document5.setDocumentTitle("Letter of Credit | Kothrud - Pune | AB01 1234 1234 1234 1234 12");
        document5.setDocumentSubtitle("Test document | ".concat(uuid5).concat(" POBNUT"));
        document5.setDocumentCreationDate("10.01.2023");
        document5.setDocumentDeletionDate("20.02.2024");
        document5.setDocumentStatus(false);
        document5.setDocumentIdentifier(uuid5);
        document5.setDocumentType("CUSTOMER");

        Document document6 = new Document();
        String uuid6 = UUID.randomUUID().toString();
        document6.setDocumentName("G.pdf");
        document6.setDocumentTitle("Letter of Credit | Koregaon Park - Pune | AB01 7654 1234 1234 1234 12");
        document6.setDocumentSubtitle("Test document | ".concat(uuid6).concat(" MCTR43"));
        document6.setDocumentCreationDate("10.01.2023");
        document6.setDocumentDeletionDate("20.02.2024");
        document6.setDocumentStatus(false);
        document6.setDocumentIdentifier(uuid6);
        document6.setDocumentType("CUSTOMER");

        DocumentsDataResponse documentsDataResponse = new DocumentsDataResponse();
        documentsDataResponse.setMoreRecordsAvailable(false);
        documentsDataResponse.setTotalAmount(100);
        documentsDataResponse.setDocuments(Arrays.asList(document, document1, document2, document3, document4, document5, document6));
        return documentsDataResponse;
    }
}
