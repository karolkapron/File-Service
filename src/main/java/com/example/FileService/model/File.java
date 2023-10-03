package com.example.FileService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

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

    @ManyToMany
    @JoinTable(
            name = "file_folder",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "folder_id")
    )
    private List<Folder> folders = new ArrayList<>();

    File(){}

}
