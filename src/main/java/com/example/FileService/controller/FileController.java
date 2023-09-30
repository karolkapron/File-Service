package com.example.FileService.controller;

import com.example.FileService.model.File;
import com.example.FileService.model.Folder;
import com.example.FileService.service.FileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping
    public File createOrUpdateFile(@RequestBody File file, Folder folder) {
        return fileService.saveFileWithFolder(file, folder);
    }

    @GetMapping
    public List<File> getAllFiles(){
        return fileService.getAllFilesDto();
    }
    @GetMapping("/{filename}")
    public ResponseEntity<File> findByFilename(@PathVariable String filename) {
        return fileService.findByFilename(filename);
    }

    @Transactional
    @DeleteMapping("/{filename}")
    public ResponseEntity<?> deleteByFilename(@PathVariable String filename) {
        return fileService.deleteByFilename(filename);
    }
    //TODO: Add put mapping

}
