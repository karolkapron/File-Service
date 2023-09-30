package com.example.FileService.model.dto;

import java.util.Set;

public record FileDto(String filename, Long sizeInByte, String folder) {
}
