package com.example.FileService.controller;

import com.example.FileService.model.File;
import com.example.FileService.model.Folder;
import com.example.FileService.service.FileService;
import com.example.FileService.service.FolderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
            private final FolderService folderService;

    FileController(FileService fileService, FolderService folderService){
        this.fileService = fileService;
        this.folderService = folderService;
    }
    //Dodawanie file z folder tylko i wylacznie jak nie ma folderu w bazie, naprawic posta
    @PostMapping
    public ResponseEntity<?> createFile(@RequestBody File file, Folder folder) {
        if (file.getFilename() == null || file.getFilename().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        if (folder.getName() != null && !folder.getName().isEmpty()) {
            Optional<Folder> optionalFolder = folderService.getFolderByName(folder.getName());
            if (optionalFolder.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            file.setFolder(folder);
        }

        File savedFile = fileService.createFile(file);
        return new ResponseEntity<>(savedFile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<File>> getAllFiles() {
        return new ResponseEntity<>(fileService.getAllFiles(), HttpStatus.OK);
    }

    @GetMapping("/{filename}")
    public Optional<File> getFileByFilename(@PathVariable String filename) {
        return  fileService.getFileByFilename(filename);
    }


    @PutMapping("/{filename}")
    public ResponseEntity<?> updateFile(@PathVariable String filename, @RequestBody File file) {
        return fileService.updateFile(filename, file);
    }

    @DeleteMapping("/{filename}")
    public ResponseEntity<Void> deleteFile(@PathVariable String filename) {
        fileService.deleteFile(filename);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


