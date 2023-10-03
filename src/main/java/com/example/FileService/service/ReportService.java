package com.example.FileService.service;

import com.example.FileService.model.Folder;
import com.example.FileService.model.dto.FileReportDto;
import com.example.FileService.model.dto.FolderReportDto;
import com.example.FileService.repository.FileRepository;
import com.example.FileService.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private FileRepository fileRepository;


    public FileReportDto getTotalStats() {
        Long totalSize = fileRepository.sumSize();
        Double avgSize = fileRepository.avgSize();
        Long highestSize = fileRepository.findTopByOrderBySizeDesc().get().getSize();
        Long lowestSize = fileRepository.findTopByOrderBySizeAsc().get().getSize();
        Long numberOfFiles = fileRepository.count();

        return new FileReportDto(totalSize, avgSize, highestSize, lowestSize, numberOfFiles);
    }

}




