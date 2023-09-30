package com.example.FileService.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String filename;
    private Long size;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Folder> folders = new ArrayList<>();

    public File(String filename, Long sizeInByte, List<Folder> folders){
        this.filename = filename;
        this.size = sizeInByte;
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

    public List<Folder> getFolder() {
        return folders;
    }
    public void setFolder(List<Folder> folders) {
        this.folders = folders;
    }
}
