package com.example.FileService.model;

import jakarta.persistence.*;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String filename;
    private Long size;

    private String folders;

    public File(String filename, Long size, String folders){
        this.filename = filename;
        this.size = size;
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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getFolder() {
        return folders;
    }

    public void setFolder(String folders) {
        this.folders = folders;
    }
}
