package com.example.FileService.repository;

import com.example.FileService.model.File;
import com.example.FileService.model.Folder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    Optional<Folder> findByName(String folderName);

    List<Folder> findBySubFoldersContaining(Folder subfolder);


}
