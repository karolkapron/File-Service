package com.example.FileService.controller;

import com.example.FileService.model.File;
import com.example.FileService.model.Folder;
import com.example.FileService.service.FileService;
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

    FileController(FileService fileService){
        this.fileService = fileService;
    }
    @PostMapping
    public ResponseEntity<File> createFile(@RequestBody File file) {
        return new ResponseEntity<>(fileService.createFile(file), HttpStatus.CREATED);
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


