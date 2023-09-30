package com.example.FileService.controller;

import com.example.FileService.model.dto.FileDto;
import com.example.FileService.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private final FileService fileService;


    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @GetMapping
    public List<FileDto> getAllFiles(){
        return fileService.getAllFilesDto();
    }

    @GetMapping("/{filename}")
    public ResponseEntity<FileDto> getFileByFilename(@PathVariable String filename){
        return fileService.getFileDtoByFilename(filename);
    }

    @PostMapping
    public void addNewFile(@RequestBody FileDto newFileDto){
        fileService.saveFileFromDto(newFileDto);
    }

    @PutMapping("/{filename}")
    public ResponseEntity<FileDto> updateFile(@PathVariable String filename, @RequestBody FileDto fileToUpdate){
        return fileService.updateFileDtoByFilename(filename, fileToUpdate);
    }

    @DeleteMapping("/{filename}")
    public ResponseEntity<Object> deleteFile(@PathVariable String filename){
        return fileService.deleteFileByFilename(filename);
    }
}
