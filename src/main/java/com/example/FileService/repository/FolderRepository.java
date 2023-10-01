package com.example.FileService.repository;

import com.example.FileService.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    Optional<Folder> findByName(String folderName);
     void deleteByName(String folderName);

}
