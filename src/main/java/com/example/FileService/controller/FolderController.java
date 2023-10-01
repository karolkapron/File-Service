package com.example.FileService.controller;

import com.example.FileService.model.Folder;
import com.example.FileService.service.FolderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/folders")
public class FolderController {
    @Autowired
    private FolderService folderService;

    public FolderController(FolderService folderService){
        this.folderService = folderService;
    }

    @PostMapping
    public Folder createOrUpdateFolder(@RequestBody Folder folder) {
        return folderService.createFolder(folder);
    }

    @GetMapping
    public Set<Folder> getAllFolders(){
        return folderService.getAllFolders();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Folder> findByName(@PathVariable String name) {
        return folderService.findByName(name);
    }


    @Transactional
    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name) {
        return folderService.deleteByName(name);
    }

    //TODO: add put request

}
