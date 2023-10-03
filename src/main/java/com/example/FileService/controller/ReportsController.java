package com.example.FileService.controller;

import com.example.FileService.model.Folder;
import com.example.FileService.model.dto.FolderReportDto;
import com.example.FileService.service.ReportService;
import com.example.FileService.model.dto.FileReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportsController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/file-report")
    public FileReportDto getTotalStats() {
        return reportService.getTotalStats();
    }

}

