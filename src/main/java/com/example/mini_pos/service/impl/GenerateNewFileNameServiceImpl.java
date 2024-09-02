package com.example.mini_pos.service.impl;

import com.example.mini_pos.service.GenerateNewFileNameService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class GenerateNewFileNameServiceImpl implements GenerateNewFileNameService {
    @Override
    public String generateNewFileName(String originalFileName) {
        //Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        //Format the current date and time to include milliseconds
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        //check if the original file name contains a period
        int lastIndex = originalFileName.lastIndexOf(".");
        if(lastIndex == -1) {
            //If no period is found , return the timestamp as the new file name
            return timestamp;
        }

        //Get the file extension
        String fileExtension = originalFileName.substring(lastIndex);
        //Generate a new file name using timestamp and original file extension
        return  timestamp + fileExtension;
    }
}
