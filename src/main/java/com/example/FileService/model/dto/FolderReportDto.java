package com.example.FileService.model.dto;

import com.example.FileService.model.Folder;

import java.util.List;

public class FolderReportDto {
    private List<Folder> topFoldersByTotalSize;
    private List<Folder> topFoldersByFileCount;
    private List<Folder> topFoldersByAverageFileSize;

    public FolderReportDto(List<Folder> topFoldersByTotalSize, List<Folder> topFoldersByFileCount) {
        this.topFoldersByTotalSize = topFoldersByTotalSize;
        this.topFoldersByFileCount = topFoldersByFileCount;
//        this.topFoldersByAverageFileSize = topFoldersByAverageFileSize;
    }

    public List<Folder> getTopFoldersByTotalSize() {
        return topFoldersByTotalSize;
    }

    public void setTopFoldersByTotalSize(List<Folder> topFoldersByTotalSize) {
        this.topFoldersByTotalSize = topFoldersByTotalSize;
    }

    public List<Folder> getTopFoldersByFileCount() {
        return topFoldersByFileCount;
    }

    public void setTopFoldersByFileCount(List<Folder> topFoldersByFileCount) {
        this.topFoldersByFileCount = topFoldersByFileCount;
    }

    public List<Folder> getTopFoldersByAverageFileSize() {
        return topFoldersByAverageFileSize;
    }

    public void setTopFoldersByAverageFileSize(List<Folder> topFoldersByAverageFileSize) {
        this.topFoldersByAverageFileSize = topFoldersByAverageFileSize;
    }
}

