package com.example.FileService.controller;

import com.example.FileService.model.File;
import com.example.FileService.model.dto.FileDto;
import com.example.FileService.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.FileService.controller.mapper.*;
import java.util.List;

import static com.example.FileService.controller.mapper.FileDtoMapper.mapFilesToFilesDto;


@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @GetMapping
    public List<FileDto> getAllFiles(){
        return mapFilesToFilesDto(fileService.getAllFiles());
    }


    @GetMapping("/{filename}")
    public ResponseEntity<File> getFileByFilename(@PathVariable String filename){
        return fileService.getFileByFilename(filename)
                .map(file -> ResponseEntity.ok(file))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public void addNewFile(@RequestBody FileDto newFile){
        File file = new File();
        file.setFilename(newFile.filename());
        file.setSizeInByte(newFile.sizeInByte());
        file.setFolder(newFile.folder());
        fileService.saveFile(file);
    }
    @PutMapping("/{filename}")
    public ResponseEntity<File> updateFile(@PathVariable String filename, @RequestBody FileDto fileToUpdate){
        return fileService.getFileByFilename(filename)
                .map(existingFile -> {
                    existingFile.setFilename(fileToUpdate.filename());
                    existingFile.setFolder(fileToUpdate.folder());
                    existingFile.setSizeInByte(fileToUpdate.sizeInByte());
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
