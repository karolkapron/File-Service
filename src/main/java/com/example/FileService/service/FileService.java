package com.example.FileService.service;

import com.example.FileService.model.File;
import com.example.FileService.model.dto.FileDto;
import com.example.FileService.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.FileService.controller.mapper.FileDtoMapper.*;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public List<FileDto> getAllFilesDto(){
        List<File> files = fileRepository.findAll();
        return mapFilesToFilesDto(files);
    }

    public ResponseEntity<FileDto> getFileDtoByFilename(String filename){
        return fileRepository.findByFilename(filename)
                .map(file -> ResponseEntity.ok(mapFileToDto(file)))
                .orElse(ResponseEntity.notFound().build());
    }

    public void saveFileFromDto(FileDto fileDto){
        File file = mapDtoToFile(fileDto);
        fileRepository.save(file);
    }

    public ResponseEntity<FileDto> updateFileDtoByFilename(String filename, FileDto fileToUpdate){
        return fileRepository.findByFilename(filename)
                .map(existingFile -> {
                    existingFile.setFilename(fileToUpdate.filename());
                    existingFile.setFolder(fileToUpdate.folder());
                    existingFile.setSizeInByte(fileToUpdate.sizeInByte());
                    fileRepository.save(existingFile);
                    return ResponseEntity.ok(mapFileToDto(existingFile));
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteFileByFilename(String filename){
        return fileRepository.findByFilename(filename)
                .map(existingFile -> {
                    fileRepository.delete(existingFile);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
