package com.example.FileService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

}
