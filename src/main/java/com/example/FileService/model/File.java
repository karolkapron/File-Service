package com.example.FileService.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String filename;
    private Long size;

    @ManyToMany
    @JoinTable(
            name = "file_folder",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "folder_id")
    )
    private List<Folder> folders = new ArrayList<>();

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
