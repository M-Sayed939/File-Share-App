package com.example.FileShare.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;
    public FileEntity saveFile(MultipartFile file) throws IOException {
        FileEntity newFileEntity = new FileEntity();
        newFileEntity.setFileName(file.getOriginalFilename());
        newFileEntity.setFileType(file.getContentType());
        newFileEntity.setData(file.getBytes());
        return fileRepository.save(newFileEntity);
    }

    public Optional<FileEntity> getFile(Long fileId) {
        return fileRepository.findById(fileId);
    }
    public void deleteFile(Long fileId) {
        fileRepository.deleteById(fileId);
    }

}
