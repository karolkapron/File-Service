package com.example.FileService.model.dto;

import com.example.FileService.model.Folder;

import java.util.Set;

public record FileDto(String filename, Long sizeInByte, Set<Folder> folder) {
}
