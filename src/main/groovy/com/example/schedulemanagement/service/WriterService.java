package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.ScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;
import com.example.schedulemanagement.dto.WriterRequestDto;
import com.example.schedulemanagement.dto.WriterResponseDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface WriterService {
    public WriterResponseDto saveWriter(WriterRequestDto dto);

    public List<WriterResponseDto> listAllWriter();

    public WriterResponseDto findWriterById(String id);

    public void deleteWriter(String id);

}
