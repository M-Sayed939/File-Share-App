package com.example.FileShare.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileEntity savedFile = fileService.saveFile(file);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + savedFile.getFileName());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long fileId) {
        return fileService.getFile(fileId)
                .map(file -> ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                        .body(file.getData()))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/delete/{fileId}")
    public ResponseEntity<String> deleteFile(@PathVariable Long fileId) {
        fileService.deleteFile(fileId);
        return ResponseEntity.status(HttpStatus.OK).body("File deleted successfully.");
    }
}
