package com.example.FileService.Controller;

import com.example.FileService.Model.File;
import com.example.FileService.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    FileService fileService;

    @GetMapping
    public List<File> getAllFiles(){
        return fileService.getAllFiles();
    }
    @GetMapping("/{filename}")
    public ResponseEntity<File> getFileByFilename(@PathVariable String filename){
        return fileService.getFileByFilename(filename)
                .map(file -> ResponseEntity.ok(file))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/{filename}")
    public ResponseEntity<File> addNewFile(@RequestBody File newFile){
        return ResponseEntity.ok(fileService.saveFile(newFile));
    }
}
