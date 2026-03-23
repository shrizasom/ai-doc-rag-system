package com.ai.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class DocumentService {

    public String processDocument(MultipartFile file) {
        try {
            // Save file locally
            File convFile = new File("temp.pdf");
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();

            // Call Python service
            RestTemplate restTemplate = new RestTemplate();

            Map<String, String> body = new HashMap<>();
            body.put("file_path", "temp.pdf");

            restTemplate.postForObject(
                "http://localhost:8000/upload",
                body,
                String.class
            );

            return "File uploaded and processed successfully";

        } catch (Exception e) {
            return "Error processing file";
        }
    }
}