package com.example.FileService.controller.mapper;

import com.example.FileService.model.File;
import com.example.FileService.model.dto.FileDto;

import java.util.List;
import java.util.stream.Collectors;

public class FileDtoMapper {
    public static List<FileDto> mapFilesToFilesDto(List<File> files){
        return files.stream()
                .map(FileDtoMapper::mapFileToDto)
                .toList();
    }
    public static FileDto mapFileToDto(File file){
        return new FileDto(file.getFilename(), file.getSizeInByte(), file.getFolder());
    }
    public static File mapDtoToFile(FileDto fileDto){
        return new File(fileDto.filename(), fileDto.sizeInByte(), fileDto.folder());
    }
}
