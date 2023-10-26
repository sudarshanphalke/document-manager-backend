package com.applicationsuites.documentmanager.controller;

import com.applicationsuites.documentmanager.dto.DocumentsDataResponse;
import com.applicationsuites.documentmanager.service.PdfService;
import com.applicationsuites.documentmanager.dto.PdfViewResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/document/{documentname}")
    public ResponseEntity<PdfViewResponse> viewPdf(@PathVariable String documentname) {
        log.debug("filename: {}", documentname);
        return ResponseEntity.ok(pdfService.getPdfEncoded(documentname));
    }

    @GetMapping("/document/download/{documentname}")
    public ResponseEntity<Resource> downloadPdf(@PathVariable String documentname) {
        Resource resource = new ClassPathResource("pdfs/" + documentname);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + documentname)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .body(resource);
    }

    @GetMapping("/documents")
    public ResponseEntity<DocumentsDataResponse> getData() {
        return ResponseEntity.ok(pdfService.getMockData());
    }
}
