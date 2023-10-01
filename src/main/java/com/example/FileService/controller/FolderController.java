package com.example.FileService.controller;
import com.example.FileService.service.FolderService;
import com.example.FileService.model.Folder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/folders")
public class FolderController {
        @Autowired
        private FolderService folderService;

        @PostMapping
        public ResponseEntity<Folder> createFolder(@RequestBody Folder folder) {
            return new ResponseEntity<>(folderService.createFolder(folder), HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<Folder>> getAllFolders() {
            return new ResponseEntity<>(folderService.getAllFolders(), HttpStatus.OK);
        }

        @GetMapping("/{name}")
        public Optional<Folder> getFolderByName(@PathVariable String name) {
            return folderService.getFolderByName(name);
        }

        @PutMapping("/{name}")
        public ResponseEntity<?> updateFolder(@PathVariable String name, @RequestBody Folder folder) {
            return  folderService.updateFolder(name, folder);
        }

        @DeleteMapping("/{name}")
        @Transactional
        public ResponseEntity<Void> deleteFolder(@PathVariable String name) {
            folderService.deleteFolder(name);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

