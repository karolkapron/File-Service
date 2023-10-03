package com.example.FileService.service;

import com.example.FileService.model.File;
import com.example.FileService.model.Folder;
import com.example.FileService.repository.FileRepository;
import com.example.FileService.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FolderRepository folderRepository;


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
        Optional<File> optionalFile = fileRepository.findByFilename(filename);
        File existFile;
        if (optionalFile.isEmpty()) {
            throw new IllegalArgumentException("Plik o podanym filename nie istnieje.");
        }else{
            existFile = optionalFile.get();
        }
        Optional<Folder> optionalFolder = folderRepository.findByName(file.getFolder().getName());
        if (optionalFolder.isPresent()) {
            existFile.setFolder(optionalFolder.get());
            fileRepository.save(existFile);
        } else {
            throw new IllegalArgumentException("Folder o podanej nazwie nie istnieje.");
        }
        return ResponseEntity.ok().build();
    }

    public void deleteFile(String filename) {
        Optional<File> file = fileRepository.findByFilename(filename);
        file.ifPresent(value -> fileRepository.deleteById(value.getId()));
    }
}


