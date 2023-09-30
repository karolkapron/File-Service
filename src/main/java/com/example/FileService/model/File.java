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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "file_folder",
            joinColumns = @JoinColumn(name = "file_id"),
            inverseJoinColumns = @JoinColumn(name = "folder_id"))
    private Set<Folder> folders = new HashSet<>();

    public File(String filename, Long sizeInByte, Set<Folder> folders){
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

    public Set<Folder> getFolder() {
        return folders;
    }

    public void setFolder(Set<Folder> folders) {
        this.folders = folders;
    }
}
