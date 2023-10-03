package com.example.FileService.model.dto;

public class FileReportDto {
    private Long totalSize;
    private Double avgSize;
    private Long highestSize;
    private Long lowestSize;
    private Long numberOfFiles;

    public FileReportDto(Long totalSize, Double avgSize, Long highestSize, Long lowestSize, Long numberOfFiles) {
        this.totalSize = totalSize;
        this.avgSize = avgSize;
        this.highestSize = highestSize;
        this.lowestSize = lowestSize;
        this.numberOfFiles = numberOfFiles;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Double getAvgSize() {
        return avgSize;
    }

    public void setAvgSize(Double avgSize) {
        this.avgSize = avgSize;
    }

    public Long getHighestSize() {
        return highestSize;
    }

    public void setHighestSize(Long highestSize) {
        this.highestSize = highestSize;
    }

    public Long getLowestSize() {
        return lowestSize;
    }

    public void setLowestSize(Long lowestSize) {
        this.lowestSize = lowestSize;
    }

    public Long getNumberOfFiles() {
        return numberOfFiles;
    }

    public void setNumberOfFiles(Long numberOfFiles) {
        this.numberOfFiles = numberOfFiles;
    }
}
