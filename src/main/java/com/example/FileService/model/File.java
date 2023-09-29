package com.example.FileService.model;

import jakarta.persistence.*;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String filename;
    private Long sizeInByte;
    private String folder; //in the future using Folder entity

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
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
