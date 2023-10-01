package com.example.FileService.service;

import com.example.FileService.model.File;
import com.example.FileService.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;


    public File createFile(File file) {
        return fileRepository.save(file);
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public Optional<File> getFileByFilename(String filename) {
        return fileRepository.findByFilename(filename);
    }

    public ResponseEntity<?> updateFile(String filename, File file) {
            fileRepository.findByFilename(filename)
                    .map(existingFile -> {
                        existingFile.setFilename(file.getFilename());
                        existingFile.setSize(file.getSize());
                        existingFile.setFolder(file.getFolder());
                        fileRepository.save(existingFile);
                        return ResponseEntity.ok().build();
                    });
        return ResponseEntity.notFound().build();
    }

    public void deleteFile(String filename) {
        Optional<File> file = fileRepository.findByFilename(filename);
        file.ifPresent(value -> fileRepository.deleteById(value.getId()));
    }
}


