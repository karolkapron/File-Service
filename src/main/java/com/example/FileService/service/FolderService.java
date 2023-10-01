package com.example.FileService.service;

import com.example.FileService.model.Folder;
import com.example.FileService.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderService {
    // Assuming you have a FolderRepository
    @Autowired
    private FolderRepository folderRepository;

    public Folder createFolder(Folder folder) {
        if(folderRepository.findByName(folder.getName()).isEmpty()) {
            return folderRepository.save(folder);
        }
            throw new InternalError("Folder exist wit that name");
    }

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    public Optional<Folder> getFolderByName(String name) {
        return folderRepository.findByName(name);
    }

    public ResponseEntity<?> updateFolder(String name, Folder folder) {
            folderRepository.findByName(name)
                    .map(existFolder -> {
                        existFolder.setName(folder.getName());
                        existFolder.setSubFolders(folder.getSubFolders());
                        folderRepository.save(existFolder);
                        return ResponseEntity.ok().build();
                    });
            return ResponseEntity.notFound().build();
    }

    public void removeSubfolderReferences(Folder folder) {
        List<Folder> referencingFolders = folderRepository.findBySubFoldersContaining(folder);
        for (Folder referencingFolder : referencingFolders) {
            referencingFolder.getSubFolders().remove(folder);
            folderRepository.save(referencingFolder);
        }
    }

    public void deleteFolder(String name) {
        Folder folder = folderRepository.findByName(name).orElseThrow(() -> new RuntimeException("Folder not found"));
        removeSubfolderReferences(folder);
        folderRepository.delete(folder);
    }
}