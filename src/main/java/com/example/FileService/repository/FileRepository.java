package com.example.FileService.repository;

import com.example.FileService.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    Optional<File> findByFilename(String filename);

    Optional<File> findTopByOrderBySizeDesc();

    Optional<File> findTopByOrderBySizeAsc();

    @Query("SELECT SUM(f.size) FROM File f")
    Long sumSize();


    @Query("SELECT AVG(f.size) FROM File f")
    Double avgSize();
}
