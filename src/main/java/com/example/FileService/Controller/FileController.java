package com.example.FileService.Controller;

import com.example.FileService.Model.File;
import com.example.FileService.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/{filename}")
    public ResponseEntity<File> updateFile(@PathVariable String filename, @RequestBody File fileToUpdate){
        return fileService.getFileByFilename(filename)
                .map(existingFile -> {
                    existingFile.setFilename(fileToUpdate.getFilename());
                    existingFile.setFolder(fileToUpdate.getFolder());
                    existingFile.setSizeInByte(fileToUpdate.getSizeInByte());
                    return ResponseEntity.ok(fileService.saveFile(existingFile));

                }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{filename}")
    public ResponseEntity<Object> deleteFile(@PathVariable String filename){
        return fileService.getFileByFilename(filename)
                .map(existingFile->{
                    fileService.deleteFile(existingFile.getId());
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
