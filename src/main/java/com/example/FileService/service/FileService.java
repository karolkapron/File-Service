package com.example.FileService.service;

import com.example.FileService.model.File;
import com.example.FileService.model.Folder;
import com.example.FileService.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    @Autowired
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getAllFilesDto(){
        return fileRepository.findAll();
    }


public File saveFileWithFolder(File file, Folder folder) {
    if (folder.getName() != null && !folder.getName().isEmpty() && !file.getFolder().contains(folder)) {
        file.getFolder().add(folder);
    }
    return fileRepository.save(file);
}

    public ResponseEntity<File> findByFilename(String filename) {
        return fileRepository.findByFilename(filename)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> deleteByFilename(String filename) {
        fileRepository.deleteByFilename(filename);
        return ResponseEntity.ok().build();
    }

}
