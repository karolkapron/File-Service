package com.example.FileService.service;

import com.example.FileService.model.File;
import com.example.FileService.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public List<File> getAllFiles(){
        return fileRepository.findAll();
    }
    public Optional<File> getFileByFilename(String filename){
        return fileRepository.findByFilename(filename);
    }
    public File saveFile(File newFile){
        return fileRepository.save(newFile);
    }
    public void deleteFile(Long id){
        fileRepository.deleteById(id);
    }
}
