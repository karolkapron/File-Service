package com.example.FileService.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String filename;
    private Long sizeInByte;

    private String folders;

    public File(String filename, Long sizeInByte, String folders){
        this.filename = filename;
        this.sizeInByte = sizeInByte;
        this.folders = folders;
    }
    File(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getSizeInByte() {
        return sizeInByte;
    }

    public void setSizeInByte(Long sizeInByte) {
        this.sizeInByte = sizeInByte;
    }

    public String getFolder() {
        return folders;
    }

    public void setFolder(String folders) {
        this.folders = folders;
    }
}
