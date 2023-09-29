package com.example.FileService.Service;

import com.example.FileService.Model.File;
import com.example.FileService.Repository.FileRepository;
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
