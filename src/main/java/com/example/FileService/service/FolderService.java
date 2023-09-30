package com.example.FileService.service;

import com.example.FileService.model.Folder;
import com.example.FileService.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FolderService {
    @Autowired
    private final FolderRepository folderRepository;

    public FolderService(FolderRepository folderRepository){
        this.folderRepository = folderRepository;
    }
    public Folder createFolder(Folder folder) {
        Optional<Folder> existingFolder = folderRepository.findByName(folder.getName());
        if (existingFolder.isPresent()) {
            throw new IllegalArgumentException("A folder with this name already exists.");
        }
        return folderRepository.save(folder);
    }

    public Set<Folder> getAllFolders() {
        return folderRepository.findAll().stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Folder::getName))));
    }

    public ResponseEntity<Folder> findByName(String name) {
        return folderRepository.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> deleteByName(String name) {
        folderRepository.deleteByName(name);
        return ResponseEntity.ok().build();
    }
}

