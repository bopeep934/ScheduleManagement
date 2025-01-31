package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.ScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ScheduleService {
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);

    public List<ScheduleResponseDto> findAllSchedule();

    public ScheduleResponseDto findScheduleById(Long id);

    public ScheduleResponseDto updateSchedule(Long id, LocalDate update, String toDo);

    public void deleteSchedule(Long id, Map<String, String> password);

}