package com.example.FileService.service;

import com.example.FileService.model.File;
import com.example.FileService.model.Folder;
import com.example.FileService.repository.FileRepository;
import com.example.FileService.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    private final FileRepository fileRepository;
    @Autowired
    private final FolderRepository folderRepository;
    public FileService(FileRepository fileRepository, FolderRepository folderRepository) {
        this.fileRepository = fileRepository;
        this.folderRepository = folderRepository;
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

    public ResponseEntity<?> updateExistingFile(String filename, File file, Folder folder){
        return fileRepository.findByFilename(filename)
                .map(existingFile -> {
                    existingFile.setFilename(file.getFilename());
                    existingFile.setSize(file.getSize());
                    fileRepository.save(existingFile);
                    return ResponseEntity.ok(existingFile);
                })
                .orElse(ResponseEntity.notFound().build());
    }




}
